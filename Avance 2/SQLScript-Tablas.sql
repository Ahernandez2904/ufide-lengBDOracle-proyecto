

CREATE TABLE PAIS
(PAIS_ID INT GENERATED ALWAYS AS IDENTITY
,NOM_PAIS VARCHAR2(30) NOT NULL
,CONSTRAINT PK_Pais_PaisId PRIMARY KEY (PAIS_ID));

CREATE TABLE PROVINCIA
(PROVINCIA_ID INT GENERATED ALWAYS AS IDENTITY
,NOM_PROVINCIA VARCHAR2(30) NOT NULL
,PAIS_ID INT NOT NULL
,CONSTRAINT PK_Provincia_ProvinciaId PRIMARY KEY (PROVINCIA_ID)
,CONSTRAINT FK_Provincia_Pais_PaisId FOREIGN KEY (PAIS_ID) REFERENCES PAIS(PAIS_ID));

CREATE TABLE CANTON
(CANTON_ID INT GENERATED ALWAYS AS IDENTITY
,NOM_CANTON VARCHAR2(30) NOT NULL
,PROVINCIA_ID INT NOT NULL
,CONSTRAINT PK_Canton_CantonId PRIMARY KEY (CANTON_ID)
,CONSTRAINT FK_Canton_Provincia_ProvinciaId FOREIGN KEY (PROVINCIA_ID) REFERENCES PROVINCIA(PROVINCIA_ID));

CREATE TABLE DISTRITO
(DISTRITO_ID INT GENERATED ALWAYS AS IDENTITY
,NOM_DISTRITO VARCHAR2(30) NOT NULL
,CANTON_ID INT NOT NULL
,CONSTRAINT PK_Distrito_DistritoId PRIMARY KEY (DISTRITO_ID)
,CONSTRAINT FK_Distrito_Canton_CantonId FOREIGN KEY (CANTON_ID) REFERENCES CANTON(CANTON_ID));

CREATE TABLE DETALLE_DIRECCION
(DETALE_DIR_ID INT GENERATED ALWAYS AS IDENTITY
,DESCRIPCION VARCHAR2(200)
,DISTRITO_ID INT NOT NULL
,CONSTRAINT PK_DetalleDir_DetalleDirId PRIMARY KEY (DETALE_DIR_ID)
,CONSTRAINT FK_DetalleDir_Distrito_DistritoId FOREIGN KEY (DISTRITO_ID) REFERENCES DISTRITO(DISTRITO_ID));

--,CONSTRAINT FK_TelefonoID_Cliente_ClienteID FOREIGN KEY (Cliente_Id) REFERENCES Cliente(Cliente_Id)
--,CONSTRAINT UQ_TELEFONO_DETALLE UNIQUE (Detalle,Cliente_Id)
--,CONSTRAINT CK_FORMATO_TEL CHECK (REGEXP_LIKE(Detalle,'[0-9][0-9][0-9]')));

CREATE TABLE CLIENTE
(CLIENTE_ID INT GENERATED ALWAYS AS IDENTITY
,NOMBRE VARCHAR2(50) NOT NULL
,PRIMER_APELLIDO VARCHAR2(20) NOT NULL
,SEGUNDO_APELLIDO VARCHAR2(20)
,DETALLE_DIR_ID INT NULL
,CONSTRAINT PK_Cliente_ClienteId PRIMARY KEY (CLIENTE_ID)
,CONSTRAINT FK_Cliente_DetalleDir_DetalleDirId FOREIGN KEY (DETALLE_DIR_ID) REFERENCES DETALLE_DIRECCION(DETALE_DIR_ID));

CREATE TABLE TIPO_CONTACTO
(TIPO_CONTACTO_ID INT GENERATED ALWAYS AS IDENTITY
,DETALLE VARCHAR2(25) NOT NULL
,CONSTRAINT PK_TipoCont_TipoContId PRIMARY KEY (TIPO_CONTACTO_ID));

CREATE TABLE CONTACTO
(CONTACTO_ID INT GENERATED ALWAYS AS IDENTITY
,TIPO_CONTACTO_ID INT NOT NULL
,VALOR VARCHAR2(50) NOT NULL
,CLIENTE_ID INT
,CONSTRAINT PK_Contacto_ContactoId PRIMARY KEY (CONTACTO_ID)
,CONSTRAINT FK_Contacto_TipoCont_TipoContId FOREIGN KEY (TIPO_CONTACTO_ID) REFERENCES TIPO_CONTACTO(TIPO_CONTACTO_ID)
,CONSTRAINT FK_Contacto_Cliente_ClienteId FOREIGN KEY (CLIENTE_ID) REFERENCES CLIENTE(CLIENTE_ID));

CREATE TABLE TIPO_VEHICULO
(TIPO_VEHICULO_ID INT GENERATED ALWAYS AS IDENTITY
,DESCRIPCION VARCHAR2(20) NOT NULL
,CONSTRAINT PK_TipoVehic_TipoVehicId PRIMARY KEY (TIPO_VEHICULO_ID));

CREATE TABLE VEHICULO
(VEHICULO_ID INT GENERATED ALWAYS AS IDENTITY
,PLACA VARCHAR2(10) NOT NULL
,TIPO_VEHICULO_ID INT NOT NULL
,MARCA VARCHAR2(15)  NULL
,MODELO INT NULL
,COLOR_HEX VARCHAR2(6)  NULL
,CONSTRAINT PK_Vehic_VehicId PRIMARY KEY (VEHICULO_ID)
,CONSTRAINT FK_Vehic_TipoVehic_TipoVehicId FOREIGN KEY (TIPO_VEHICULO_ID) REFERENCES TIPO_VEHICULO(TIPO_VEHICULO_ID));


--Tabal para definir alguna categoria para el parqueo ejemplo: 
CREATE TABLE CATEGORIA_ESPACIO
(CATEGORIA_ID INT GENERATED ALWAYS AS IDENTITY
,DESCRIPCION VARCHAR2(25) NOT NULL
,CONSTRAINT PK_CatEspacio_CategId PRIMARY KEY (CATEGORIA_ID))

CREATE TABLE CATEGORIA_ESTADO
(CATEGORIA_ID INT GENERATED ALWAYS AS IDENTITY
,DESCRIPCION VARCHAR2(25) NOT NULL
,CONSTRAINT PK_CatEstado_CategId PRIMARY KEY (CATEGORIA_ID))

CREATE TABLE ESTADO
(ESTADO_ID INT GENERATED ALWAYS AS IDENTITY
,DESCRIPCION VARCHAR2(25) NOT NULL
,CATEGORIA_ID INT NULL
,CONSTRAINT PK_Estado_EstadoId PRIMARY KEY (ESTADO_ID)
,CONSTRAINT FK_Estado_CatEstado_CategId FOREIGN KEY (CATEGORIA_ID) REFERENCES CATEGORIA_ESTADO(CATEGORIA_ID))

CREATE TABLE PARQUEO
(PARQUEO_ID INT GENERATED ALWAYS AS IDENTITY
,DESCRIPCION VARCHAR2(25) NOT NULL
,DETALLE_DIR_ID INT NULL
,ESTADO_ID INT NOT NULL
,CONSTRAINT PK_Parqueo_ParqueoId PRIMARY KEY (PARQUEO_ID)
,CONSTRAINT FK_Parqueo_DetalleDir_DetalleDirId FOREIGN KEY (DETALLE_DIR_ID) REFERENCES DETALLE_DIRECCION(DETALE_DIR_ID)
,CONSTRAINT FK_Parqueo_Estado_EstadoId FOREIGN KEY (ESTADO_ID) REFERENCES ESTADO(ESTADO_ID));

CREATE TABLE SECCION_PARQUEO
(SECCION_ID INT GENERATED ALWAYS AS IDENTITY
,DESCRIPCION VARCHAR2(25) NOT NULL
,PARQUEO_ID INT NOT NULL
,ESTADO_ID INT NOT NULL
,CONSTRAINT PK_Seccion_SeccionId PRIMARY KEY (SECCION_ID)
,CONSTRAINT FK_Parqueo_Parqueo_ParqueoId FOREIGN KEY (PARQUEO_ID) REFERENCES PARQUEO(PARQUEO_ID)
,CONSTRAINT FK_SeccionParq_Estado_EstadoId FOREIGN KEY (ESTADO_ID) REFERENCES ESTADO(ESTADO_ID));

CREATE TABLE ESPACIO_PARQUEO
(ESPACIO_ID INT GENERATED ALWAYS AS IDENTITY
,CATEGORIA_ID INT NOT NULL
,ESTADO_ID INT NOT NULL
,SECCION_ID INT NOT NULL
,CONSTRAINT PK_EspaParq_EspaId PRIMARY KEY (ESPACIO_ID)
,CONSTRAINT FK_EspaParq_CategEspa_CategId FOREIGN KEY (CATEGORIA_ID) REFERENCES CATEGORIA_ESPACIO(CATEGORIA_ID)
,CONSTRAINT FK_EspaParq_Estado_EstadoId FOREIGN KEY (ESTADO_ID) REFERENCES ESTADO(ESTADO_ID)
,CONSTRAINT FK_EspaParq_Seccion_SeccionId FOREIGN KEY (SECCION_ID) REFERENCES SECCION_PARQUEO(SECCION_ID));

CREATE TABLE INVENTARIO
(INVENTARIO_ID INT GENERATED ALWAYS AS IDENTITY
,PRODUCT_ID INT 
,ESTADO_ID INT
,CONSTRAINT PK_Invent_InventId PRIMARY KEY (INVENTARIO_ID)
,CONSTRAINT FK_Invent_Estado_EstadoId FOREIGN KEY (ESTADO_ID) REFERENCES ESTADO(ESTADO_ID));

CREATE TABLE TICKET
(TICKET_ID INT GENERATED ALWAYS AS IDENTITY
,FECHA_CREACION TIMESTAMP NOT NULL
,FECHA_ENTRADA TIMESTAMP NULL
,FECHA_SALIDA TIMESTAMP NULL
,INVENTARIO_ID INT
,VEHICULO_ID INT NOT NULL
,ESTADO_ID INT NOT NULL
,ESPACIO_ID INT NULL
,CONSTRAINT PK_Ticket_TicketId PRIMARY KEY (TICKET_ID)
,CONSTRAINT FK_Ticket_Invent_InventId FOREIGN KEY (INVENTARIO_ID) REFERENCES INVENTARIO(INVENTARIO_ID)
,CONSTRAINT FK_Ticket_Vehic_VehicId FOREIGN KEY (VEHICULO_ID) REFERENCES VEHICULO(VEHICULO_ID)
,CONSTRAINT FK_Ticket_Estado_EstadoId FOREIGN KEY (ESTADO_ID) REFERENCES ESTADO(ESTADO_ID)
,CONSTRAINT FK_Ticket_EspaParq_EspaId FOREIGN KEY (ESPACIO_ID) REFERENCES ESPACIO_PARQUEO(ESPACIO_ID));

CREATE TABLE FACTURA
(FACTURA_ID INT GENERATED ALWAYS AS IDENTITY
,FECHA_CREACION TIMESTAMP NOT NULL
,CLIENTE_ID INT
,ESTADO_ID INT
,TOTAL_FACTURA NUMBER
,CONSTRAINT PK_Fact_FactId PRIMARY KEY (FACTURA_ID)
,CONSTRAINT FK_Fact_Cliente_ClienteId FOREIGN KEY (CLIENTE_ID) REFERENCES CLIENTE(CLIENTE_ID)
,CONSTRAINT FK_Fact_Estado_EstadoId FOREIGN KEY (ESTADO_ID) REFERENCES ESTADO(ESTADO_ID));

CREATE TABLE DETALLE_FACTURA
(DETALLE_FACT_ID INT GENERATED ALWAYS AS IDENTITY
,FACTURA_ID INT NOT NULL
,INVENTARIO_ID INT NOT NULL
,CANTIDAD INT NOT NULL
,SUBTOTAL NUMBER NULL
,DESCUENTO NUMBER NULL
,IMPUESTO NUMBER NULL
,TOTAL_LINE NUMBER NULL
,CONSTRAINT PK_DetFact_DetFactId PRIMARY KEY (DETALLE_FACT_ID)
,CONSTRAINT FK_DetFact_Fact_FactId FOREIGN KEY (FACTURA_ID) REFERENCES FACTURA(FACTURA_ID)
,CONSTRAINT FK_DetFact_Invent_InventId FOREIGN KEY (INVENTARIO_ID) REFERENCES INVENTARIO(INVENTARIO_ID))
