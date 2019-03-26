package server;

public class Grade {
    private int offerId;
    private boolean evaluation;

    public Grade(int offerId, boolean evaluation) {
        this.offerId = offerId;
        this.evaluation = evaluation;
    }

    public Grade() {
    }

    public int getOfferId() {
        return offerId;
    }


    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public boolean isEvaluation() {
        return evaluation;
    }

    public void setEvaluation(boolean evaluation) {
        this.evaluation = evaluation;
    }
}
