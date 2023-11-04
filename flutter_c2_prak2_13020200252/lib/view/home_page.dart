import 'package:flutter/material.dart';
import 'package:flutter_c2_prak2_13020200252/model/data_mahasiswa.dart';
import 'package:flutter_c2_prak2_13020200252/view/ringkasan_page.dart';

class HomePage extends StatefulWidget {
  const HomePage({super.key});

  static const String routeName = '/';

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  final angkatan = <String>[
    '2023',
    '2022',
    '2021',
    '2020',
    '2019',
    '2018',
    '2017',
    '2016',
    '2015',
    '2014'
  ];

  bool isChecked1 = false;
  bool isChecked2 = false;
  bool isChecked3 = false;
  bool isChecked4 = false;
  bool isChecked5 = false;
  bool isChecked6 = false;
  final TextEditingController namaController = TextEditingController();
  String? valueStambuk;
  String? valueNama;
  String? prodi;
  String? valueAngkatan;
  List<String>? valueMinat = [];
  final TextEditingController stambukController = TextEditingController();

  @override
  void dispose() {
    stambukController.dispose();
    namaController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.deepPurple,
        title: const Text(
          'Praktikum 2',
          style: TextStyle(color: Colors.white),
        ),
      ),
      body: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 24.0),
        child: SingleChildScrollView(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.start,
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              const SizedBox(height: 24),
              TextField(
                controller: stambukController,
                decoration: const InputDecoration(
                  hintText: 'Masukkan Stambuk',
                ),
                onChanged: (value) async {
                  valueStambuk = value;
                },
              ),
              const SizedBox(height: 16),
              TextField(
                controller: namaController,
                decoration: const InputDecoration(
                  hintText: 'Masukkan Nama',
                ),
                onChanged: (value) {
                  valueNama = value;
                },
              ),
              const SizedBox(height: 16),
              DropdownButtonFormField<String>(
                decoration: const InputDecoration(
                  border: InputBorder.none,
                ),
                hint: const Text('-Pilihan Angkatan-'),
                items: angkatan.map((String value) {
                  return DropdownMenuItem<String>(
                    value: value,
                    child: Text(value),
                  );
                }).toList(),
                onChanged: (value) {
                  valueAngkatan = value;
                  debugPrint('Tap $value');
                },
              ),
              const SizedBox(height: 16),
              const Text(
                'Program Studi',
                textDirection: TextDirection.ltr,
                style: TextStyle(
                  fontSize: 13,
                  color: Colors.black54,
                ),
              ),
              SizedBox(
                width: double.infinity,
                child: Column(
                  children: [
                    RadioListTile(
                      title: const Text("Teknik Informatika"),
                      value: "Teknik Informatika",
                      groupValue: prodi,
                      onChanged: (value) {
                        setState(() {
                          prodi = value.toString();
                          debugPrint('tap $value');
                        });
                      },
                      dense: true,
                    ),
                    RadioListTile(
                      title: const Text("Sistem Informasi"),
                      value: "Sistem Informasi",
                      groupValue: prodi,
                      onChanged: (value) {
                        setState(() {
                          prodi = value.toString();
                          debugPrint('tap $value');
                        });
                      },
                      dense: true,
                    ),
                  ],
                ),
              ),
              const SizedBox(height: 16),
              const Text(
                'Minat',
                textDirection: TextDirection.ltr,
                style: TextStyle(
                  fontSize: 13,
                  color: Colors.black54,
                ),
              ),
              CheckboxListTile(
                title: const Text('Badan Eksekutif Mahasiswa'),
                value: isChecked1,
                onChanged: (bool? value) {
                  setState(() {
                    isChecked1 = value!;
                    if (isChecked1) {
                      valueMinat!.add('- Badan Eksekutif Mahasiswa');
                    } else {
                      valueMinat!.remove('- Badan Eksekutif Mahasiswa');
                    }
                    debugPrint('tap $value Badan Eksekutif Mahasiswa');
                  });
                },
                controlAffinity: ListTileControlAffinity.leading,
                dense: true,
              ),
              CheckboxListTile(
                title: const Text('Penulisan Karya Ilmiah'),
                value: isChecked2,
                onChanged: (bool? value) {
                  setState(() {
                    isChecked2 = value!;
                    if (isChecked2) {
                      valueMinat!.add('- Penulisan Karya Ilmiah');
                    } else {
                      valueMinat!.remove('- Penulisan Karya Ilmiah');
                    }
                    debugPrint('tap $value Penulisan Karya Ilmiah');
                  });
                },
                controlAffinity: ListTileControlAffinity.leading,
                dense: true,
              ),
              CheckboxListTile(
                title: const Text('Kewirausahaan'),
                value: isChecked3,
                onChanged: (bool? value) {
                  setState(() {
                    isChecked3 = value!;
                    if (isChecked3) {
                      valueMinat!.add('- Kewirausahaan');
                    } else {
                      valueMinat!.remove('- Kewirausahaan');
                    }
                    debugPrint('tap $value Kewirausahaan');
                  });
                },
                controlAffinity: ListTileControlAffinity.leading,
                dense: true,
              ),
              CheckboxListTile(
                title: const Text('Kesenian'),
                value: isChecked4,
                onChanged: (bool? value) {
                  setState(() {
                    isChecked4 = value!;
                    if (isChecked4) {
                      valueMinat!.add('- Kesenian');
                    } else {
                      valueMinat!.remove('- Kesenian');
                    }
                    debugPrint('tap $value Kesenian');
                  });
                },
                controlAffinity: ListTileControlAffinity.leading,
                dense: true,
              ),
              CheckboxListTile(
                title: const Text('Jurnalistik'),
                value: isChecked5,
                onChanged: (bool? value) {
                  setState(() {
                    isChecked5 = value!;
                    if (isChecked5) {
                      valueMinat!.add('- Jurnalistik');
                    } else {
                      valueMinat!.remove('- Jurnalistik');
                    }

                    debugPrint('tap $value Jurnalistik');
                  });
                },
                controlAffinity: ListTileControlAffinity.leading,
                dense: true,
              ),
              CheckboxListTile(
                title: const Text('Olahraga'),
                value: isChecked6,
                onChanged: (bool? value) {
                  setState(() {
                    isChecked6 = value!;
                    if (isChecked6) {
                      valueMinat!.add('- Olahraga');
                    } else {
                      valueMinat!.remove('- Olahraga');
                    }
                    debugPrint('tap $value Olahraga');
                  });
                },
                controlAffinity: ListTileControlAffinity.leading,
                dense: true,
              ),
              const SizedBox(height: 24),
              Container(
                alignment: Alignment.topRight,
                child: ElevatedButton(
                  style: ButtonStyle(
                    backgroundColor: MaterialStateProperty.all<Color>(
                      Colors.deepPurple,
                    ),
                  ),
                  onPressed: () {
                    debugPrint('Tap Button Tampilkan Ringkasan');
                    Navigator.pushNamed(
                      context,
                      RingkasanPage.routeName,
                      arguments: DataMahasiswa(
                        valueStambuk,
                        valueNama,
                        valueAngkatan,
                        prodi,
                        valueMinat,
                      ),
                    );
                  },
                  child: const Text(
                    'TAMPILKAN RINGKASAN',
                    style: TextStyle(color: Colors.white),
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
