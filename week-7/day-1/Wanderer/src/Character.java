import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Character extends PositionedImage {

    List<String> ways = Arrays.asList("up", "down", "left", "right");

    public Character(String filename, int posX, int posY) {
        super(filename, posX, posY);
    }

    public void passOverCurrentPosition(Character character) {
        character.posX = this.posX;
        character.posY = this.posY;
    }


    public int convertFieldCoordinateToArrayCoordinate(int xCoord, int yCoord, int givenField, int height, int width) {
        if (givenField == 0) {
            xCoord /= width;
            yCoord /= height;
        }
        int coord = (10 * yCoord) + xCoord;
        return coord;
    }

    public int convertArrayCoordinateToFieldCoordinatesX(int coord, int xCoord) {
        xCoord = (coord / 10) * 72;
        return xCoord;
    }

    public int convertArrayCoordinateToFieldCoordinatesY(int coord, int yCoord) {
        yCoord = (coord % 10) * 72;
        return yCoord;
    }

    public int nextFieldIs(String way, ArrayList map2, int height, int width, int field) {
        int nextFieldIs = 0;
        int first;
        if (way == "up") {
            first = this.posY - field;
            if (first < 0) {
            } else {
                int xCoord = this.posX / field;
                int yCoord = (this.posY - field) / field;
                int coord = convertFieldCoordinateToArrayCoordinate(xCoord, yCoord, 1, 720, 720);
                nextFieldIs = (Integer) map2.get(coord);
            }
        } else if (way == "down") {
            first = this.posY + field;
            if (first >= height) {
            } else {
                int xCoord = this.posX / field;
                int yCoord = (this.posY + field) / field;
                int coord = convertFieldCoordinateToArrayCoordinate(xCoord, yCoord, 1, 720, 720);
                nextFieldIs = (Integer) map2.get(coord);
            }
        } else if (way == "left") {
            first = this.posX - field;
            if (first < 0) {
            } else {
                int xCoord = (this.posX - field) / field;
                int yCoord = this.posY / field;
                int coord = convertFieldCoordinateToArrayCoordinate(xCoord, yCoord, 1, 720, 720);
                nextFieldIs = (Integer) map2.get(coord);
            }
        } else {
            first = this.posX + field;
            if (first >= width) {
            } else {
                int xCoord = (this.posX + field) / field;
                int yCoord = this.posY / field;
                int coord = convertFieldCoordinateToArrayCoordinate(xCoord, yCoord, 1, 720, 720);
                nextFieldIs = (Integer) map2.get(coord);
            }
        }
        return nextFieldIs;
    }

}
