package by.markovsky.roulette.entity;

/**
 * Created by Pavel Markovsky on 11.01.2018.
 */
public class Player {

    private int score = 0;

    public void addScore(){
        ++score;
    }
    public void emptyScore(){
        score = 0;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return score == player.score;
    }
    @Override
    public int hashCode() {
        return score;
    }
    @Override
    public String toString() {
        return "Player{" +
                "score=" + score +
                '}';
    }

}
