package api.product.offer.repository;

import api.product.offer.model.Offer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class OfferRepository extends DummyOfferRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public void OfferRepositoryImpl() {
        this.sessionFactory = sessionFactory;
    }

    @Autowired
    public OfferRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Offer save(Offer offer) {
        Session session = sessionFactory.getCurrentSession();
        session.save(offer);
        return offer;
    }

    @Override
    public void deleteById(String id) {
        Session session = sessionFactory.getCurrentSession();
        Offer offer = session.load(Offer.class, id);
        if (offer != null) {
            session.delete(offer);
        }
    }

    @Override
    public Optional<Offer> findById(String id) {
        Session session = sessionFactory.getCurrentSession();
        Offer offer = session.get(Offer.class, id);
        return Optional.ofNullable(offer);
    }

    @Override
    public List<Offer> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Offer", Offer.class).list();
    }
}
