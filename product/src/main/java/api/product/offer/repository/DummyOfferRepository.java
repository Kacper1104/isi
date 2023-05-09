package api.product.offer.repository;

import api.product.offer.model.Offer;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Optional;

public abstract class DummyOfferRepository {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public abstract Offer save(Offer offer);

    public abstract void deleteById(String id);

    public abstract Optional<Offer> findById(String id);

    public abstract List<Offer> findAll();
}