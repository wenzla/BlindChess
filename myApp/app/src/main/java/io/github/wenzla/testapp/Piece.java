package io.github.wenzla.testapp;

import android.graphics.Paint;

/**
 * Contains data about a piece.
 */
public class Piece
{
    private String type;
    private Location location;
    private Paint paint;
    public int color;

    /**
     * Create a new Piece object.
     *
     * @param type the type of the piece
     * @param location the location of the symbol on the board
     */
    public Piece(String type, Location location, int color)
    {
        this.type = type;
        this.location = location;
        this.color = color;
        paint = new Paint(color);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(32f);
    }

    /**
     * Gets the location of the piece on the board.
     *
     * @return location the location of the piece on the board
     */
    public Location getLocation()
    {
        return location;
    }

    /**
     * Sets the location of the piece on the board.
     *
     * @param newLocation the new location of the piece
     */
    public void setLocation(Location newLocation)
    {
        location = newLocation;
    }

    public Paint getPaint(){
        return paint;
    }

    /**
     * Gets the symbol representation of the piece on the board.
     *
     * @return symbol the symbol representation of the piece
     */
    public char getSymbol()
    {
        switch (type)
        {
            case "WHITE_KING":
                return (char)0x2654;
            case "WHITE_QUEEN":
                return (char)0x2655;
            case "WHITE_BISHOP":
                return (char)0x2657;
            case "WHITE_KNIGHT":
                return (char)0x2658;
            case "WHITE_ROOK":
                return (char)0x2656;
            case "WHITE_PAWN":
                return (char)0x2659;
            case "BLACK_KING":
                return (char)0x265A;
            case "BLACK_QUEEN":
                return (char)0x265B;
            case "BLACK_BISHOP":
                return (char)0x265D;
            case "BLACK_KNIGHT":
                return (char)0x265E;
            case "BLACK_ROOK":
                return (char)0x265C;
            case "BLACK_PAWN":
                return (char)0x265F;
        }

        return 0;
    }

    /**
     * Gets the type of the piece.
     *
     * @return type the type of the piece
     */
    public String getType()
    {
        return type;

    }

}
