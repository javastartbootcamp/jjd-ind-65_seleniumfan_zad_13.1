package pl.javastart.voting;

import java.util.List;

/**
 * Możesz dodać kolejne metody i pola do klasy. Nie zmieniaj istniejących metod.
 */
public class VotingResult {
    private List<Vote> list;

    public VotingResult(List<Vote> list) {
        this.list = list;
    }

    /**
     * Metoda powinna drukować wyniki głosowania w takiej postaci:
     * Głosów za: 56.53%
     * Głosów przeciw: 35.00%
     * Wstrzymało się: 8.47%
     */
    public void printResults() {
        double voteFor = 0;
        double voteAgainst = 0;
        double voteWithHeld = 0;
        for (Vote vote : list) {
            if (vote.getVote().equals(MemberVote.ZA)) {
                voteFor++;
            } else if (vote.getVote().equals(MemberVote.PRZECIW)) {
                voteAgainst++;
            } else {
                voteWithHeld++;
            }
        }

        double percentFor = (voteFor * 100) / list.size();
        double percentAgainst = (voteAgainst * 100) / list.size();
        double percentWithHeld = (voteWithHeld * 100) / list.size();
        System.out.printf("Głosów za: %.2f%%\n", percentFor);
        System.out.printf("Głosów przeciw: %.2f%%\n", percentAgainst);
        System.out.printf("Wstrzymało się: %.2f%%\n", percentWithHeld);
    }

    /**
     * Metoda przyjmuje imię i nazwisko głosującego, np "Zigniew Siobro".
     * Uzupełnij tę metodę, żeby drukowała informację w formie:
     * Zigniew Siobro: ZA
     * Nie zmieniaj sygnatury tej metody!
     */
    public void printVoteForVoter(String voterName) {
        for (Vote vote : list) {
            String voter = vote.getVoter();
            if (voter.equals(voterName)) {
                System.out.println(voter + ": " + vote.getVote().getName());
            }
        }
    }
}
