package pl.javastart.voting;

public class Vote {
    private String voter;
    private MemberVote vote;

    public Vote(String voter, MemberVote vote) {
        this.voter = voter;
        this.vote = vote;
    }

    public String getVoter() {
        return voter;
    }

    public void setVoter(String voter) {
        this.voter = voter;
    }

    public MemberVote getVote() {
        return vote;
    }

    public void setVote(MemberVote vote) {
        this.vote = vote;
    }
}
