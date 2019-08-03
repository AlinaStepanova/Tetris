package com.avs.brick.game.figures.factory;

import android.graphics.Path;

import com.avs.brick.game.enums.FigureType;

import java.util.Random;

import static com.avs.brick.game.Values.EXTRA_ROWS;

public class FigureCreator {

    private final Random random;
    private FigureType currentFigureType;
    private FigureType nextFigureType;

    public FigureCreator() {
        random = new Random();
        currentFigureType = null;
        nextFigureType = selectFigure();
    }

    private void initFigures() {
        currentFigureType = nextFigureType;
        nextFigureType = selectFigure();
    }

    private FigureType selectFigure() {
        return FigureType.values()[random.nextInt(FigureType.values().length)];
    }

    public FigureType getCurrentFigureType() {
        if (currentFigureType == null) {
            return selectFigure();
        } else {
            return currentFigureType;
        }
    }

    public FigureType getNextFigureType() {
        return nextFigureType;
    }

    public FigureType createNextFigure() {
        initFigures();
        return getNextFigureType();
    }

    public static Path createSmallSquareFigure(int i, int j, int squareWidth, int scale) {
        Path path = new Path();
        int delta = j * squareWidth - (EXTRA_ROWS - 2) * squareWidth - scale;
        path.moveTo(i * squareWidth, delta);
        path.lineTo(i * squareWidth, delta - squareWidth);
        path.lineTo(i * squareWidth + squareWidth, delta - squareWidth);
        path.lineTo(i * squareWidth + squareWidth, delta);
        path.close();
        return path;
    }
}