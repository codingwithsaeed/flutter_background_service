package id.flutter.flutter_background_service;

public final class NotificationData {
    private final String day;
    private final String jalali;
    private final String miladi;
    private final String hijri;
    private final String theme;

    public NotificationData(String day, String jalali, String miladi, String hijri, String theme) {
        this.day = day;
        this.jalali = jalali;
        this.miladi = miladi;
        this.hijri = hijri;
        this.theme = theme;
    }

    public String getDay() {
        return day;
    }

    public String getJalali() {
        return jalali;
    }

    public String getMiladi() {
        return miladi;
    }

    public String getHijri() {
        return hijri;
    }

    public String getTheme() {
        return theme;
    }
}
