
public class TennisGame3 implements TennisGame {

    private int scorePlayer2;
    private int scorePlayer1;
    private final String player1Name;
    private final String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String s;
        if (scoreIsLowerThan4()) {
            return lowerThan4();
        } else {
            if (scorePlayer1 == scorePlayer2)
                return "Deuce";
            s = scorePlayer1 > scorePlayer2 ? player1Name : player2Name;
            return ((scorePlayer1 - scorePlayer2)*(scorePlayer1 - scorePlayer2) == 1) ? "Advantage " + s : "Win for " + s;
        }
    }

    private String lowerThan4() {
        String s;
        String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        s = p[scorePlayer1];
        return (scorePlayer1 == scorePlayer2) ? s + "-All" : s + "-" + p[scorePlayer2];
    }
    
    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            this.scorePlayer1++;
        else
            this.scorePlayer2++;
        
    }

    private boolean scoreIsLowerThan4() {
        return bothScoreLowerThan4() && additionDifferentTo6();
    }

    private boolean additionDifferentTo6() {
        return scorePlayer1 + scorePlayer2 != 6;
    }

    private boolean bothScoreLowerThan4() {
        return scorePlayer1 < 4 && scorePlayer2 < 4;
    }

}
