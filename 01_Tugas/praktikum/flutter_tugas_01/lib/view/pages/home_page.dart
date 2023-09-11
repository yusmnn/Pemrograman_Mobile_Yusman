import 'package:flutter/material.dart';
import 'package:flutter_tugas_01/utils/components/button/box__text_button.dart';
import 'package:flutter_tugas_01/utils/components/field/box_field.dart';

import '../../utils/components/button/box_icon_button.dart';
import '../../utils/const/text_description.dart';

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  final double headerHeight = 200;
  final double favoritedHeight = 50;

  @override
  Widget build(BuildContext context) {
    final double top = headerHeight - favoritedHeight / 2;
    final double bottom = favoritedHeight / 2;
    final double left = MediaQuery.of(context).size.width - 90;

    return Scaffold(
      appBar: AppBar(
        title: const Text(titleAppBar),
      ),
      body: SingleChildScrollView(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            Stack(
              clipBehavior: Clip.none,
              children: [
                Stack(
                  clipBehavior: Clip.none,
                  children: [
                    Padding(
                      padding: EdgeInsets.only(bottom: bottom),
                      child: Container(
                        width: double.infinity,
                        height: headerHeight,
                        decoration: const BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage(
                              'assets/images/header.jpg',
                            ),
                            fit: BoxFit.cover,
                          ),
                        ),
                      ),
                    ),
                  ],
                ),
                Positioned(
                  top: top,
                  left: left,
                  child: Container(
                    width: MediaQuery.of(context).size.width,
                    padding: const EdgeInsets.symmetric(horizontal: 20),
                    child: const Row(
                      mainAxisAlignment: MainAxisAlignment.spaceBetween,
                      children: [
                        BoxIconButton(icon: Icons.star_rounded),
                      ],
                    ),
                  ),
                ),
              ],
            ),
            Padding(
              padding: const EdgeInsets.symmetric(horizontal: 20, vertical: 10),
              child: Container(
                alignment: Alignment.topLeft,
                child: const Text(
                  title,
                  style: TextStyle(
                    fontSize: 24,
                    fontWeight: FontWeight.bold,
                  ),
                ),
              ),
            ),
            const Padding(
              padding: EdgeInsets.symmetric(
                horizontal: 20,
              ),
              child: Column(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  BoxField(
                    formType: 'Stambuk : ',
                    hintText: 'Your Stambuk',
                    textInputType: TextInputType.number,
                  ),
                  BoxField(
                    formType: 'Name : ',
                    hintText: 'Your Name',
                    textInputType: TextInputType.text,
                  ),
                  SizedBox(height: 36),
                  Text(
                    description,
                    textAlign: TextAlign.left,
                    style: TextStyle(
                      color: Colors.black,
                      fontSize: 14,
                      fontWeight: FontWeight.w500,
                    ),
                  ),
                  SizedBox(height: 36),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.end,
                    crossAxisAlignment: CrossAxisAlignment.center,
                    children: [
                      BoxTextButton(buttonText: 'SIMPAN'),
                      SizedBox(width: 36),
                      BoxTextButton(buttonText: 'BATAL'),
                    ],
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}
