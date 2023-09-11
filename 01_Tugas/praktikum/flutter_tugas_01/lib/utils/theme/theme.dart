import 'package:flutter/material.dart';

class StyleTheme {
  static ThemeData themeData() {
    return ThemeData(
      useMaterial3: true,
      colorScheme: ColorScheme.fromSeed(
        seedColor: const Color(0xff008080),
      ),
      appBarTheme: const AppBarTheme(
        color: Color(0xff008080),
        elevation: 4,
        titleTextStyle: TextStyle(
          color: Colors.white,
          fontSize: 24,
          fontWeight: FontWeight.w700,
        ),
      ),
      scaffoldBackgroundColor: Colors.white,
    );
  }
}
