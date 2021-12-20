
public class TennisGame3 implements TennisGame {

    private int scorePlayer2;
    private int scorePlayer1;
    private String player1Name;
    private String player2Name;

    public TennisGame3(String p1N, String p2N) {
        this.player1Name = p1N;
        this.player2Name = p2N;
    }

    public String getScore() {
        String s;
        if (scorePlayer1 < 4 && scorePlayer2 < 4 && !(scorePlayer1 + scorePlayer2 == 6)) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            s = p[scorePlayer1];
            return (scorePlayer1 == scorePlayer2) ? s + "-All" : s + "-" + p[scorePlayer2];
        } else {
            if (scorePlayer1 == scorePlayer2)
                return "Deuce";
            s = scorePlayer1 > scorePlayer2 ? player1Name : player2Name;
            return ((scorePlayer1 - scorePlayer2)*(scorePlayer1 - scorePlayer2) == 1) ? "Advantage " + s : "Win for " + s;
        }
    }
    
    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.scorePlayer1++;
        else
            this.scorePlayer2++;
        
    }

}
