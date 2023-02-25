CREATE TABLE CLIENTE(
    ID_CLIENTE NUMERIC(6,0) NOT NULL PRIMARY KEY,
    RAZON_SOCIAL VARCHAR2(260) NOT NULL UNIQUE,
    RUC CHAR(11) NOT NULL UNIQUE,
    DIRECCION VARCHAR2(400) NOT NULL,
    TELEFONO VARCHAR2(20) NULL,
    CORREO VARCHAR2(60) NULL,
    ESTADO CHAR(1) DEFAULT '1' NOT NULL 
);

CREATE SEQUENCE SEQ_CLIENTE;

INSERT INTO CLIENTE(ID_CLIENTE,RAZON_SOCIAL,RUC,DIRECCION,TELEFONO,CORREO)
VALUES(SEQ_CLIENTE.NEXTVAL,'CLARO EMPRESAS','20544987258','AV. LARCO 237-SAN ISIDRO','456-4574','contacto@claro.com.pe');

INSERT INTO CLIENTE(ID_CLIENTE,RAZON_SOCIAL,RUC,DIRECCION,TELEFONO,CORREO)
VALUES(SEQ_CLIENTE.NEXTVAL,'TELEFONICA EMPRESAS','20544987259','AV. LARCO 238-SAN ISIDRO','456-4575','contacto@telefonica.com.pe');

INSERT INTO CLIENTE(ID_CLIENTE,RAZON_SOCIAL,RUC,DIRECCION,TELEFONO,CORREO)
VALUES(SEQ_CLIENTE.NEXTVAL,'ENTEL PERU','20544987200','AV. AREQUIPA-LIMA CERCADO','456-4004','contacto@entel.com.pe');

commit;

select * from Cliente;