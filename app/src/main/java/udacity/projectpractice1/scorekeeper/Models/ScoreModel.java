package udacity.projectpractice1.scorekeeper.Models;

/**
 * This class contain the data models of the socre keeper.
 * */

public class ScoreModel {

    private int teamScore = 0;
    private int teamFouls = 0;

    /**
     * This constructor initalize the score of team.
     * */
    public ScoreModel() {};


//-----------------------------------------------------------------------------Set and Get Function-------------------------------------------------------------


    /**
     * This method set the new score of team after changing.
     *
     * @param newScore The new score to set the team score.
     * */
    public void setTeamScore(int newScore) {
        this.teamScore = newScore;
    }

    /**
     * This method set the new fouls of team
     *
     * @param newFouls the new fouls to set the team fouls.
     * */
    public void setTeamFouls(int newFouls) {
        this.teamFouls = newFouls;
    }

    /**
     * This method get the current score of team.
     *
     * @return the score of team.
     * */
    public int getTeamScore() {
        return this.teamScore;
    }

    /**
     * This method get the current fouls of team.
     *
     * @return the fouls of team.
     * */
    public int getTeamFouls() {
        return this.teamFouls;
    }

//-----------------------------------------------------------------------------Update and Reset Function--------------------------------------------------------

    /**
     * This method update the score with long shoot.
     * */
    public void longShootUpdate() {
        this.teamScore += 3;
    }

    /**
     * This method update the score with short shoot.
     * */
    public void shortShootUpdate() {
        this.teamScore += 1;
    }

    /**
     * This method update the score with fouls.
     * */
    public void foulsUpdate() {
        this.teamFouls += 1;
    }

    /**
     * This method update the score from opponent if the number of opponent's fouls is larger or equal to 2.
     * */
    public void socreUpdateFromOpponentFouls() {
        this.teamScore += 2;
    }

    /**
     * This method reset the score.
     * */
    public void resetTeamScoreAndFouls() {
        this.teamScore = 0;
        this.teamFouls = 0;
    }
}
