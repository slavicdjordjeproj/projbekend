insert into "tip_racuna"("id","naziv","oznaka","opis")
values (nextval('tip_racuna_seq'),'a','1','asdads');
insert into "tip_racuna"("id","naziv","oznaka","opis")
values (nextval('tip_racuna_seq'),'b','2','' );
insert into "tip_racuna"("id","naziv","oznaka","opis")
values (nextval('tip_racuna_seq'),'c','3','');
insert into "tip_racuna"("id","naziv","oznaka","opis")
values (nextval('tip_racuna_seq'),'d','4','dsadsa');
insert into "tip_racuna"("id","naziv","oznaka","opis")
values (nextval('tip_racuna_seq'),'e','5','dsadsaasd');
insert into "tip_racuna"("id","naziv","oznaka","opis")
values (nextval('tip_racuna_seq'),'f','7','');
insert into "tip_racuna"("id","naziv","oznaka","opis")
values (nextval('tip_racuna_seq'),'g','8','');
insert into "tip_racuna"("id","naziv","oznaka","opis")
values (nextval('tip_racuna_seq'),'h','9','asd');
insert into "tip_racuna"("id","naziv","oznaka","opis")
values (nextval('tip_racuna_seq'),'i','10','');
		
	

insert into "klijent" ("id","ime","prezime","broj_lk","kredit")
values(nextval('klijent_seq'),'ana','babic',111111112,1);
insert into "klijent" ("id","ime","prezime","broj_lk","kredit")
values(nextval('klijent_seq'),'ana','savic',111111111,6);
insert into "klijent" ("id","ime","prezime","broj_lk","kredit")
values(nextval('klijent_seq'),'beba','petrovic',122222222,5);
insert into "klijent" ("id","ime","prezime","broj_lk","kredit")
values(nextval('klijent_seq'),'mile','milosevic',123333333,4);
insert into "klijent" ("id","ime","prezime","broj_lk","kredit")
values(nextval('klijent_seq'),'cile','gilic',123444444,3);
insert into "klijent" ("id","ime","prezime","broj_lk","kredit")
values(nextval('klijent_seq'),'gile','tilic',123455555,2);
insert into "klijent" ("id","ime","prezime","broj_lk","kredit")
values(nextval('klijent_seq'),'zile','zilic',123456666,7);
insert into "klijent" ("id","ime","prezime","broj_lk","kredit")
values(nextval('klijent_seq'),'tile','zilic',123456777,8);
insert into "klijent" ("id","ime","prezime","broj_lk","kredit")
values(nextval('klijent_seq'),'pero','petrovic',123456788,9);
insert into "klijent" ("id","ime","prezime","broj_lk","kredit")
values(nextval('klijent_seq'),'perica','petrovic',123456789,10);

insert into "racun" ("id","naziv","oznaka","opis","tip_racuna","klijent")
values (nextval('racun_seq'),'qq','cc','',10,2);
insert into "racun" ("id","naziv","oznaka","opis","tip_racuna","klijent")
values (nextval('racun_seq'),'qw','xb','',9,3);
insert into "racun" ("id","naziv","oznaka","opis","tip_racuna","klijent")
values (nextval('racun_seq'),'qe','xv','',8,4);
insert into "racun" ("id","naziv","oznaka","opis","tip_racuna","klijent")
values (nextval('racun_seq'),'qr','xc','',7,1);
insert into "racun" ("id","naziv","oznaka","opis","tip_racuna","klijent")
values (nextval('racun_seq'),'qt','xx','',6,5);
insert into "racun" ("id","naziv","oznaka","opis","tip_racuna","klijent")
values (nextval('racun_seq'),'ww','zb','',5,6);
insert into "racun" ("id","naziv","oznaka","opis","tip_racuna","klijent")
values (nextval('racun_seq'),'we','zv','',4,7);
insert into "racun" ("id","naziv","oznaka","opis","tip_racuna","klijent")
values (nextval('racun_seq'),'wr','zc','',3,8);
insert into "racun" ("id","naziv","oznaka","opis","tip_racuna","klijent")
values (nextval('racun_seq'),'wt','zx','',2,9);
insert into "racun" ("id","naziv","oznaka","opis","tip_racuna","klijent")
values (nextval('racun_seq'),'ee','zz','',1,10);


