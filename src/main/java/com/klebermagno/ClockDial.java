package com.klebermagno;


import javax.swing.*;
import java.awt.*;

/** Represents an clock dial.
 * @author Kleber Magno Maciel Vieira
 * @author klebermagno@me.com
 * @version 1.0.0
 */
class ClockDial extends JPanel {

    AnalogClock parent;

    /**
     * Create a Clock Dial.
     * @param pt receive a AnalogClock.
     */
    public ClockDial(AnalogClock pt) {
        setSize(pt.width + 10, pt.height);
        parent = pt;
    }

    /**
     * Paint the component.
     * @param g receive a Graphics object.
     */
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        createBackground(g2d);

        createDial(g2d);

        createDigitalClock(g2d);

        double minsecdeg = (double) Math.PI / 30;
        double hrdeg = (double) Math.PI / 6;

        createSecondHand(g2d, minsecdeg);

        createMinuteHand(g2d, minsecdeg);

        createHourHand(g2d, hrdeg);

    }

    /**
     * Draw the background.
     * @param g2d receive a Graphics object.
     */
    private void createBackground(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }

    /**
     * Draw the clock dial.
     * @param g2d receive a Graphics object.
     */
    private void createDial(Graphics2D g2d) {
        g2d.setColor(Color.CYAN);
        g2d.fillOval(5, 5, 480, 480);
        g2d.setColor(Color.BLACK);
        g2d.fillOval(10, 10, 470, 470);

        g2d.setColor(Color.CYAN);
        g2d.setFont(g2d.getFont().deriveFont(Font.BOLD, 32));


        for (int i = 1; i <= 12; i++) {

            int x = 240 - (i / 12) * 11 + (int) (210 * Math.sin(i * Math.PI / 6));
            int y = (253 - (int) (210 * Math.cos(i * Math.PI / 6)));
            g2d.fillOval(x, y, 5, 5);
        }
    }

    /**
     *  Draw digital clock.
     * @param g2d receive a Graphics object.
     */
    private void createDigitalClock(Graphics2D g2d) {
        Font font = new Font("SansSerif", 0, 85);
        g2d.setFont(font);

        String separetor = ":";
        separetor = ((parent.sec % 2) == 0)?":":" ";

        g2d.setColor(Color.WHITE);
        String hour =String.format("%02d", parent.digitalHour);
        String minute = String.format("%02d", parent.min);
        String second = String.format("%02d", parent.sec);
        g2d.drawString(hour + separetor + minute+ separetor + second, 65, 237);
    }

    /**
     * Draw hour hand.
     * @param g2d receive a Graphics object.
     * @param hrdeg hour degree.
     */
    private void createHourHand(Graphics2D g2d, double hrdeg) {
        int x = parent.center + (int) (160 * Math.sin(parent.hour * hrdeg + parent.min * Math.PI / 360));
        int y = parent.center - (int) (160 * Math.cos(parent.hour * hrdeg + parent.min * Math.PI / 360));
        g2d.setColor(Color.BLUE);
        g2d.setStroke(new BasicStroke(8));
        g2d.drawLine(parent.center, parent.center, x, y);
    }

    /**
     * Draw minute hand.
     * @param g2d receive a Graphics object.
     * @param minsecdeg minute and second degree.
     */
    private void createMinuteHand(Graphics2D g2d, double minsecdeg) {
        int x = parent.center + (int) (190 * Math.sin(parent.min * minsecdeg));
        int y = parent.center - (int) (190 * Math.cos(parent.min * minsecdeg));

        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(5));
        g2d.drawLine(245, 245, x, y);
    }

    /**
     * Draw second hand.
     * @param g2d receive a Graphics object.
     * @param minsecdeg minute and second degree.
     */
    private void createSecondHand(Graphics2D g2d, double minsecdeg) {
        int x = parent.center + (int) (210 * Math.sin(parent.sec * minsecdeg));
        int y = parent.center - (int) (210 * Math.cos(parent.sec * minsecdeg));
        g2d.setColor(Color.GRAY);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(parent.center, parent.center, x, y);
    }
}