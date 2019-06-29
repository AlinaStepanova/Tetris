package com.example.alina.tetris.figures.figure_l;

import android.content.Context;
import android.graphics.Path;
import android.graphics.Point;

import com.example.alina.tetris.enums.FigureType;
import com.example.alina.tetris.figures.Figure;


public class LFourthFigure extends Figure {

    public LFourthFigure(int squareWidth, int scale, Context context) {
        super(squareWidth, scale, context);
        this.scale += squareWidth;
    }

    public LFourthFigure(int widthSquare, Context context, Point point) {
        super(widthSquare, context, point);
    }

    public LFourthFigure(int widthSquare, int scale, Context context, Point point) {
        super(widthSquare, scale, context, point);
    }

    @Override
    public void initFigureMask() {
        super.initFigureMask();
        figureMask[0][0] = true;
        figureMask[0][1] = true;
        figureMask[0][2] = true;
        figureMask[1][0] = true;
    }

    @Override
    public FigureType getRotatedFigure() {
        return FigureType.L_THIRD_FIGURE;
    }

    @Override
    public int getWidthInSquare() {
        return 3;
    }

    @Override
    public int getHeightInSquare() {
        return 2;
    }

    @Override
    public Path getPath() {
        Path path = new Path();
        path.moveTo(point.x, point.y - scale);
        path.lineTo(point.x + squareWidth * 3, point.y - scale);
        path.lineTo(point.x + squareWidth * 3, point.y + squareWidth - scale);
        path.lineTo(point.x + squareWidth, point.y + squareWidth - scale);
        path.lineTo(point.x + squareWidth, point.y + squareWidth * 2 - scale);
        path.lineTo(point.x, point.y + squareWidth * 2 - scale);
        path.close();
        return path;
    }
}