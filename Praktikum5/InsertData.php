<?php
    include 'Koneksi.php';

    $hasil = array();

    $_POST = json_decode(file_get_contents('php://input'), true);
    $stb = $_POST["stb"];
    $nama = $_POST["nama"];
    $angkatan = $_POST["angkatan"];

    $ps = $con->stmt_init();

    $ps->prepare("insert into tb_mhs values (?, ?, ?)");
    $ps->bind_param("ssi", $stb, $nama, $angkatan);
    if($ps->execute())
        $hasil['hasil'] = 1;
    else
        $hasil['hasil']= 0;

    $ps->close();
    $con->close();

    echo json_encode($hasil);
?>