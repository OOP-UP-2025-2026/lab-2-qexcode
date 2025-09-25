package ua.opnu;

public class TimeSpan {
    private int hours;
    private int minutes;

    // Конструктор
    TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = hours;
            this.minutes = minutes;
        }
    }

    int getHours() {
        return hours;
    }

    int getMinutes() {
        return minutes;
    }

    void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) return;

        this.hours += hours;
        this.minutes += minutes;

        if (this.minutes >= 60) {
            this.hours += this.minutes / 60;
            this.minutes = this.minutes % 60;
        }
    }

    void addTimeSpan(TimeSpan timespan) {
        add(timespan.getHours(), timespan.getMinutes());
    }

    double getTotalHours() {
        return hours + minutes / 60.0;
    }

    int getTotalMinutes() {
        return hours * 60 + minutes;
    }

    void subtract(TimeSpan span) {
        int total1 = getTotalMinutes();
        int total2 = span.getTotalMinutes();

        if (total2 > total1) return;

        int diff = total1 - total2;
        hours = diff / 60;
        minutes = diff % 60;
    }

    void scale(int factor) {
        if (factor <= 0) return;

        int total = getTotalMinutes() * factor;
        hours = total / 60;
        minutes = total % 60;
    }

    @Override
    public String toString() {
        return hours + "h " + minutes + "m";
    }
}