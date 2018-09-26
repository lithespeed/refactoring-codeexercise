package main.java;

public class TennisGame1 implements TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        String score;
        int tempScore=0;
        if (m_score1==m_score2)
        {
            score = getTiedScore(m_score1);
        }
        else if (m_score1>=4 || m_score2>=4)
        {
            score = getOtherScore(m_score1, m_score2);
        }
        else
        {
            score = getPlayerScore(m_score1) + "-" + getPlayerScore(m_score2);
        }
        return score;
    }

    private String getOtherScore(int m_score1, int m_score2) {
        int minusResult = m_score1-m_score2;

        return getOtherScore(minusResult);
    }

    private String getOtherScore(int minusResult) {
        String score;
        if (minusResult==1) score ="Advantage player1";
        else if (minusResult ==-1) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    private String getPlayerScore(int m_score) {
        String score;
        switch(m_score)
        {
            case 0:
                score ="Love";
                break;
            case 1:
                score ="Fifteen";
                break;
            case 2:
                score ="Thirty";
                break;
            case 3:
                score ="Forty";
                break;
            default:
                score = "";
                break;
        }
        return score;
    }

    private String getTiedScore(int m_score) {
        String score;
        switch (m_score1)
        {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }
}
