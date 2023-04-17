package api.product.offer.controller;

import api.product.offer.model.Offer;
import api.product.offer.model.OfferDTO;
import api.product.offer.model.OffersFilters;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OfferController {

    @GetMapping("/")
    public List<Offer> getHighlightedOffers() {
        return List.of(Offer.builder().offerId("Hello world").build());
    }

    @PostMapping("/get/")
    public List<Offer> getOffers(@RequestBody OffersFilters offersFilters) {
        return List.of(Offer.builder().offerId("Hello world").build());
    }

    @PostMapping("/")
    public Offer createOffer(@RequestBody OfferDTO offerDto) {
        return Offer.builder().offerId(offerDto.getOfferId()).build();
    }

    @PutMapping("/{id}")
    public Offer editOffer(@PathVariable String id ,@RequestBody OfferDTO offerDTO) {
        return Offer.builder().offerId(offerDTO.getOfferId()).build();
    }

    @DeleteMapping("/{id}")
    public void deleteOffer(@PathVariable String id) {
    }

    @GetMapping("/{id}")
    public Offer getById(@PathVariable String id) {
        return Offer.builder().offerId(id).build();
    }

    @GetMapping("/my/")
    public List<Offer> getMyOffers() {
        return List.of(Offer.builder().offerId("Hello world").build());
    }

    @PostMapping("/subscribe/{id}")
    public void subscribe(@PathVariable String id) {

    }

    @PostMapping("/unsubscribe/{id}")
    public void unsubscribe(@PathVariable String id) {

    }
}
