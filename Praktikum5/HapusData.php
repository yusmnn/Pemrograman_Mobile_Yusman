<?php
    include 'Koneksi.php';

    $hasil = array();

    $_POST = json_decode(file_get_contents('php://input'), true);
    $stb = $_POST["stb"];

    $ps = $con->stmt_init();
    $ps->prepare("delete from tb_mhs where stb=?");
    $ps->bind_param("s", $stb);

    if ($ps->execute()) {
        $hasil['hasil'] = 1;
    }else{
        $hasil['hasil'] = 0;
    }

    $ps->close();
    $con->close();

    echo json_encode($hasil);
?>