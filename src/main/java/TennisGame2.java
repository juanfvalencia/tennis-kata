
public class TennisGame2 implements TennisGame
{
    public int p1Point = 0;
    public int p2Point = 0;

    public String p1Res = "";
    public String p2Res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        if (equalsScore()){
            score = equalScore(score);
        }
        else if (scorePlayers())
        {
            score = scoreGreaterThan4();
        }
        else
        {
            score = differentScore(p1Point) + "-" + differentScore(p2Point);
        }

        return score;
    }

    private boolean scorePlayers() {
        return p1Point >=4 || p2Point >=4;
    }

    private boolean equalsScore() {
        return p1Point == p2Point;
    }

    private String equalScore(String score) {
        switch (p1Point){
            case 0: return "Love-All";
            case 1: return "Fifteen-All";
            case 2: return "Thirty-All";
            default: return "Deuce";
        }
    }


    public void wonPoint(String player) {
        if (player == "player1")
            p1Point++;
        else
            p2Point++;
    }

    private String scoreGreaterThan4() {
        int minusResult = p1Point - p2Point;
        switch(minusResult){
            case 1: case -1: return advantageScore(minusResult);
            default: return winScore(minusResult);
        }
    }

    private String advantageScore(int minusResult){
        return minusResult == 1 ? "Advantage player1" : "Advantage player2";

    }

    private String winScore(int minusResult){
        return minusResult >= 2 ? "Win for player1": "Win for player2";
    }

    private String differentScore(int scorePlayer) {
        switch(scorePlayer)
        {
            case 0: return "Love";
            case 1: return "Fifteen";
            case 2: return "Thirty";
            default: return "Forty";
        }
    }
}