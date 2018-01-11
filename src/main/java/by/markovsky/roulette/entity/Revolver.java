package by.markovsky.roulette.entity;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Pavel Markovsky on 11.01.2018.
 */
public class Revolver {

    private int[] bulletSlots;
    private int currentPos;

    public Revolver() {
        bulletSlots = new int[6];
        currentPos = -1;
    }

    public int[] getBulletSlots() {
        return bulletSlots;
    }
    public void setBulletSlots(int[] bulletSlots) {
        this.bulletSlots = bulletSlots;
    }
    public int getCurrentPos() {
        return currentPos;
    }
    public void setCurrentPos(int currentPos) {
        this.currentPos = currentPos;
    }

    public void load(){
        Random bullet = new Random();
        bulletSlots[bullet.nextInt(6)] = 1;
    }
    public void roll(){
        Random bullet = new Random();
        currentPos = bullet.nextInt(6);
    }
    public boolean shoot(){
        if(bulletSlots[currentPos] == 1)
            return true;
        else if(currentPos == 5){
            currentPos = 0;
            return false;
        }
        else{
            ++currentPos;
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Revolver revolver = (Revolver) o;

        if (currentPos != revolver.currentPos) return false;
        return Arrays.equals(bulletSlots, revolver.bulletSlots);
    }
    @Override
    public int hashCode() {
        int result = Arrays.hashCode(bulletSlots);
        result = 31 * result + currentPos;
        return result;
    }
    @Override
    public String toString() {
        return "Revolver{" +
                "bulletSlots=" + Arrays.toString(bulletSlots) +
                ", currentPos=" + currentPos +
                '}';
    }

}
