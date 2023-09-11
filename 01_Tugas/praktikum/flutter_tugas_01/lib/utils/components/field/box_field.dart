import 'package:flutter/material.dart';

class BoxField extends StatelessWidget {
  const BoxField(
      {super.key,
      required this.formType,
      required this.hintText,
      required this.textInputType});

  final String formType;
  final String hintText;
  final TextInputType textInputType;

  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: [
        Text(
          formType,
          style: const TextStyle(
            color: Colors.black,
            fontSize: 16,
            fontWeight: FontWeight.w500,
          ),
        ),
        SizedBox(
          width: MediaQuery.of(context).size.width - 130,
          height: 56,
          child: TextField(
            cursorColor: Colors.black,
            keyboardType: textInputType,
            decoration: InputDecoration(
              hintText: hintText,
              isDense: true,
              labelStyle: const TextStyle(
                color: Colors.black,
              ),
            ),
          ),
        ),
      ],
    );
  }
}
