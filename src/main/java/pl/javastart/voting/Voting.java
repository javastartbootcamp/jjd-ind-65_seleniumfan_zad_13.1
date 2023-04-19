package pl.javastart.voting;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Voting {

    public static void main(String[] args) {
        List<String> voters = new ArrayList<>();

        // możesz dowolnie dodawać / usuwać dane testowe
        voters.add("Jan Kowalski");
        voters.add("Zigniew Siobro");
        voters.add("Zbyszek Stonoga");

        Voting voting = new Voting();

        VotingResult votingResult = voting.executeVoting(voters, new Scanner(System.in));
        votingResult.printResults();
        votingResult.printVoteForVoter("Jan Kowalski");
        votingResult.printVoteForVoter("Zigniew Siobro");
        votingResult.printVoteForVoter("Zbyszek Stonoga");
    }

    /**
     * Uzupełnij metodę metodę, ale nie zmieniaj jej sygnatury! (typu tego, co przyjmuje i zwraca).
     * do wczytywania danych od użytkownika użyj scannera z parametru
     * Metoda powinna pobrać głos dla każdego przekazanego głosującego i zapisać wyniki głosowania do VotingResult
     */
    VotingResult executeVoting(List<String> voters, Scanner scanner) {
        List<Vote> votes = new ArrayList<>();
        for (String voter : voters) {
            printVotingRules(voter);
            MemberVote memberVote = getMemberVote(scanner, voter);
            votes.add(new Vote(voter, memberVote));
        }
        return new VotingResult(votes);
    }

    private MemberVote getMemberVote(Scanner scanner, String voter) {
        String vote;
        MemberVote memberVote = null;
        vote = scanner.nextLine();
        do {
            switch (vote) {
                case "z" -> memberVote = MemberVote.FOR;
                case "p" -> memberVote = MemberVote.AGAINST;
                case "w" -> memberVote = MemberVote.ABSTAIN;
                default -> {
                    System.err.println("Oddaj prawidłowy głos (p)ośle\n");
                    printVotingRules(voter);
                }
            }
        } while (Objects.isNull(memberVote));
        return memberVote;
    }

    private void printVotingRules(String voter) {
        System.out.print("Pośle " + voter + "! ");
        System.out.println("Zagłosuj na ustawę podając odpowiednią literę: ");
        System.out.println("z -> głos 'za'");
        System.out.println("p -> głos 'przeciw'");
        System.out.println("w -> wstrzymanie się od głosu");
    }
}
