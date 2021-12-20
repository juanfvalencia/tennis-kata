
public class TennisGame1 implements TennisGame {
    
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    private final String player1Name;
    private final String player2Name;


    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.player1Name))
            scorePlayer1 += 1;
        else
            scorePlayer2 += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore = 0;
        if (scorePlayer1 == scorePlayer2)
        {
            score = equalsScoreString();
        }
        else if (scorePlayer1>=4 || scorePlayer2>=4)
        {
            score = scoreGreaterThan4();
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = scorePlayer1;
                else { score += "-"; tempScore = scorePlayer2;}
                switch(tempScore)
                {
                    case 0:
                        return "Love";
                    case 1:
                        return "Fifteen";
                    case 2:
                        return "Thirty";
                    case 3:
                        return "Forty";
                }
            }
        }
        return score;
    }
    private String equalsScoreString() {
        String score;
        switch (scorePlayer1)
        {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";

        }
    }
    private String scoreGreaterThan4() {
        int minusResult = scorePlayer1 - scorePlayer2;
        switch(minusResult){
            case 1: case -1: return advantageScore(minusResult);
            default: return winScore(minusResult);
        }
    }

    private String advantageScore(int minusResult){
        switch(minusResult){
            case 1: return "Advantage player1";
            default: return "Advantage player2";
        }
    }

    private String winScore(int minusResult){
        return minusResult >= 2 ? "Win for player1": "Win for player2";
    }
}
