package pl.javastart.voting;

public enum MemberVote {
    ZA("ZA"),
    PRZECIW("PRZECIW"),
    WSTRZYMAL_SIE("WSTRZYMAŁ SIĘ");

    private String name;

    MemberVote(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
