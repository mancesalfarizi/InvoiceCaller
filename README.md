# InvoiceCaller


First of all, I will import the invoice.csv data into postgresql and separate it into two files:
1. list of users who have paid, I will use the query:
create table bayar_lunas as select * from master where paymentstatus like '%successfully%' or paymentstatus like '%Transaction%';

2. For a list of users who have printed invoices but haven't paid yet, I will use the query:
create table belum_bayar as select * from master where paymentstatus not like '%successfully%' or paymentstatus not like '%Transaction%';

In the java language program there will be 3 files:
1. awalTahun.java
This file is the data of the user who paid for the first 3 months (January-March)
in this database, I will call user database with their invoice id and give them a message:
“Terima kasih karena Anda telah melakukan pembayaran pada invoice <ID Invoice>. Anda berhak mendapatkan diskon awal tahun sebesar 10%!”

2. akhirTahun.java
This file is the data of users who paid for the last 3 months (October - December)
in this database, I will call user database with their invoice id and give them a message:
“Terima kasih karena Anda telah melakukan pembayaran pada invoice <ID Invoice>. Anda berhak mendapatkan diskon akhir tahun sebesar 20%!”. 

3. belumBayar.java
This file is the data of users who have not made a payment, separated in the unpaid table
In this database, I will call user database with their invoice id and give them a message:
“Terima kasih karena Anda telah melakukan pembayaran pada invoice <ID Invoice>. Anda berhak mendapatkan diskon akhir tahun sebesar 20%!”.
