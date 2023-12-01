<?php
    include 'Koneksi.php';

    $hasil = array();

    $_POST = json_decode(file_get_contents('php://input'),true);
    $stbLama = $_POST["stb_lama"];
    $stb = $_POST["stb"];
    $nama = $_POST["nama"];
    $angkatan = $_POST["angkatan"];

    $ps = $con->stmt_init();
    $ps->prepare("update tb_mhs set stb=?, nama=?, angkatan=? where stb=?");
    $ps->bind_param("ssis", $stb, $nama, $angkatan, $stbLama);
    if ($ps->execute()) {
        $hasil['hasil'] = 1;
    }else{
        $hasil['hasil'] = 0;
    }

    $ps->close();
    $con->close();

    echo json_encode($hasil);
?>