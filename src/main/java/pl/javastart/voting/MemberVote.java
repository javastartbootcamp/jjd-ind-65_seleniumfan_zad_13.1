package pl.javastart.voting;

public enum MemberVote {
    FOR("ZA"),
    AGAINST("PRZECIW"),
    ABSTAIN("WSTRZYMAŁ SIĘ");

    private String name;

    MemberVote(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
