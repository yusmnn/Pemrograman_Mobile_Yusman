import 'package:flutter/material.dart';

class BoxIconButton extends StatelessWidget {
  const BoxIconButton({super.key, required this.icon});
  final IconData icon;

  @override
  Widget build(BuildContext context) {
    return Container(
      decoration: BoxDecoration(
        color: Colors.grey,
        borderRadius: BorderRadius.circular(10.0),
      ),
      child: IconButton(
          color: Colors.grey,
          onPressed: () {},
          icon: Icon(
            icon,
            color: const Color(0xffe5e4e2),
            size: 36,
          )),
    );
  }
}
