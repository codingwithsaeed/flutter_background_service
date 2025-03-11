import 'dart:convert' show jsonEncode;

class NotificationData {
  final String day;
  final String jalali;
  final String miladi;
  final String hijri;
  final String theme;
  const NotificationData({
    required this.day,
    required this.jalali,
    required this.miladi,
    required this.hijri,
    required this.theme,
  });
  Map<String, dynamic> _toMap() => {'day': day, 'jalali': jalali, 'miladi': miladi, 'hijri': hijri, 'theme': theme};
  String toJson() => jsonEncode(_toMap());
}
