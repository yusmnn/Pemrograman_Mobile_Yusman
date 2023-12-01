<?php
    include 'Koneksi.php';
    include 'Mahasiswa.php';

    $hasil = array();
    $result = $con->query("select * from tb_mhs");

    $i = 0;
    while ($record = $result->fetch_assoc()) {
        $hasil[$i] = new Mahasiswa($record["stb"],$record["nama"],$record["angkatan"]);
        $i++;
    }

    echo json_encode($hasil)
?>