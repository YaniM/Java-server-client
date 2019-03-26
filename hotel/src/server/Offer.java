package server;

import java.util.List;

public class Offer {
    private int offerId;
    private String destination;
    private String nameOfHotel;
    private double price;
    private double rating;
    private List<Integer> evaluation;

    public Offer() {
    }

    public Offer(int offerId, String destination, String nameOfHotel, double price, double rating, List<Integer> evaluation) {
        this.offerId = offerId;
        this.destination = destination;
        this.nameOfHotel = nameOfHotel;
        this.price = price;
        this.rating = rating;
        this.evaluation = evaluation;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getNameOfHotel() {
        return nameOfHotel;
    }

    public void setNameOfHotel(String nameOfHotel) {
        this.nameOfHotel = nameOfHotel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<Integer> getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(List<Integer> evaluation) {
        this.evaluation = evaluation;
    }
}
