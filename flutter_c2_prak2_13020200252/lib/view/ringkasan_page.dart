import 'package:flutter/material.dart';
import 'package:flutter_c2_prak2_13020200252/model/data_mahasiswa.dart';

class RingkasanPage extends StatefulWidget {
  const RingkasanPage({super.key});

  static const String routeName = '/ringkasan';

  @override
  State<RingkasanPage> createState() => _RingkasanPageState();
}

class _RingkasanPageState extends State<RingkasanPage> {
  @override
  Widget build(BuildContext context) {
    final DataMahasiswa data =
        ModalRoute.of(context)!.settings.arguments as DataMahasiswa;
    return Scaffold(
      appBar: AppBar(
        automaticallyImplyLeading: false,
        backgroundColor: Colors.deepPurple,
        title: const Text(
          'Praktikum 2',
          style: TextStyle(color: Colors.white),
        ),
      ),
      body: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 24.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.start,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            const SizedBox(height: 24),
            const Text(
              'Ringkasan',
              style: TextStyle(
                fontSize: 24,
                fontWeight: FontWeight.bold,
              ),
            ),
            const SizedBox(height: 24),
            Table(
              border: TableBorder.all(color: Colors.transparent),
              columnWidths: const {
                4: IntrinsicColumnWidth(),
                1: FlexColumnWidth(2),
              },
              children: [
                TableRow(
                  children: [
                    const Text('Stambuk', style: TextStyle(fontSize: 16)),
                    Text(data.stambuk ?? 'Data Tidak ada',
                        style: const TextStyle(fontSize: 16)),
                  ],
                ),
                TableRow(
                  children: [
                    const Text('Nama', style: TextStyle(fontSize: 16)),
                    Text(data.nama ?? 'Data Tidak ada',
                        style: const TextStyle(fontSize: 16)),
                  ],
                ),
                TableRow(
                  children: [
                    const Text('Angkatan', style: TextStyle(fontSize: 16)),
                    Text(data.angkatan ?? 'Data Tidak ada',
                        style: const TextStyle(fontSize: 16)),
                  ],
                ),
                TableRow(
                  children: [
                    const Text('Program Studi', style: TextStyle(fontSize: 16)),
                    Text(data.prodi ?? 'Data Tidak ada',
                        style: const TextStyle(fontSize: 16)),
                  ],
                ),
                TableRow(
                  children: [
                    const Text('Minat', style: TextStyle(fontSize: 16)),
                    Expanded(
                      child: SizedBox(
                        height: 200,
                        child: ListView.builder(
                          shrinkWrap: true,
                          physics: const NeverScrollableScrollPhysics(),
                          itemCount: data.minat!.length,
                          itemBuilder: (context, index) {
                            return Text(
                              data.minat![index],
                              style: const TextStyle(fontSize: 16),
                            );
                          },
                        ),
                      ),
                    )
                  ],
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
