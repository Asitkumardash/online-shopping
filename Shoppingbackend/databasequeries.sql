CREATE TABLE category(

 id IDENTITY,
 name VARCHAR(50),
 description VARCHAR(255),
 image_url VARCHAR(50),
 is_active BOOLEAN,
 
 CONSTRAINT pk_category_id PRIMARY KEY (id)



);


create table product (

	pid IDENTITY primary key,
	pname VARCHAR(50),
	pdesc VARCHAR(255),
	pimage VARCHAR(50) ,
	price number(9),
	pcolor VARCHAR(20),
	cid NUMBER(4) references category(id) on delete cascade,
	is_active BOOLEAN 
      );

      
    CREATE TABLE supplier(
      supid IDENTITY,
     supname VARCHAR(50),
     supdescription VARCHAR(255),
	  is_active BOOLEAN,
      CONSTRAINT pk_supplier_supid PRIMARY KEY (id)
     
     );
      
      
     create table stock (
	
	stockid IDENTITY primary key,
	pid number(4),
	sid number(4),
	price number(9),
	quantity number(9),
	is_active boolean
	
);

create table usertable (
	uid IDENTITY primary key,
	pno VARCHAR(20)  unique,
	pw varchar(20) ,
	fname varchar(20) ,
	lname varchar(20) ,
	email varchar(100) unique,
	add1 varchar(100) ,
	add2 varchar(100) ,
	add3 varchar(100) ,
	city varchar(100) ,
	state varchar(100),
	pincode number(6) ,
	cartid number(4),
	role varchar(10) ,
	is_active boolean 
	
);

create table address (

	addid IDENTITY primary key,
	aid number(4) not null,
	add1 varchar(100) not null,
	add2 varchar(100) not null,
	add3 varchar(100) not null,
	city varchar(100) not null,
	state varchar(100) not null,
	pincode number(6) not null,
	is_active boolean not null
);

create table cart (

	cartid IDENTITY primary key,
	items number(5),
	totalcost number(15) ,
	is_active boolean not null
	
);

create table cartitem (

	itemid IDENTITY primary key,
	userid number(5) ,
	pid number(5) ,
	cprice number(9) ,
	cquantity number(4) ,
	ctotal number(15) ,
	oid number(6),
	is_active boolean not null,
	constraint fk_key_user foreign key (userid) references usertable(uid),
	constraint fk_key_product foreign key (pid) references product(pid)
	
	
);