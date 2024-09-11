select * from jefe;
select * from invoice;

SELECT * FROM invoice WHERE document_type = 'Type1';


update jefe set email = 'camilo_escobar1993@hotmail.com' where cod_jefe = 'J002';


SELECT * FROM INVOICE WHERE TRUNC(DUE_DATE) >= TO_DATE('15/09/24', 'DD-MM-YY');

SELECT TO_CHAR(DUE_DATE, 'DD-MON-YYYY HH24:MI:SS') AS formatted_date
FROM invoice;

UPDATE INVOICE
SET DUE_DATE = ADD_MONTHS(DUE_DATE, 1)
WHERE TO_CHAR(DUE_DATE, 'MM') = '08';


INSERT INTO jefe (cod_jefe, name, last_name, email)
VALUES ('J001', 'John', 'Doe', 'camiloescobar04241993@gmail.com');

INSERT INTO jefe (cod_jefe, name, last_name, email)
VALUES ('J002', 'Jane', 'Doe', 'Urrego.dani@gmail.com');

INSERT INTO jefe (cod_jefe, name, last_name, email)
VALUES ('J003', 'Michael', 'Johnson', 'michael.johnson@example.com');

INSERT INTO jefe (cod_jefe, name, last_name, email)
VALUES ('J004', 'Emily', 'Davis', 'emily.davis@example.com');

INSERT INTO jefe (cod_jefe, name, last_name, email)
VALUES ('J005', 'Anna', 'Martinez', 'anna.martinez@example.com');


INSERT INTO invoice (due_date, document_type, document_number, name, last_name, last_name2, cod_jefe)
VALUES (TO_DATE('2024-08-15', 'YYYY-MM-DD'), 'Type1', 'DOC001', 'John', 'Doe', 'Smith', 'J001');

INSERT INTO invoice (due_date, document_type, document_number, name, last_name, last_name2, cod_jefe)
VALUES (TO_DATE('2024-08-16', 'YYYY-MM-DD'), 'Type2', 'DOC002', 'Jane', 'Doe', 'Smith', 'J002');

INSERT INTO invoice (due_date, document_type, document_number, name, last_name, last_name2, cod_jefe)
VALUES (TO_DATE('2024-08-17', 'YYYY-MM-DD'), 'Type1', 'DOC003', 'Michael', 'Johnson', 'Brown', 'J001');

INSERT INTO invoice (due_date, document_type, document_number, name, last_name, last_name2, cod_jefe)
VALUES (TO_DATE('2024-08-18', 'YYYY-MM-DD'), 'Type3', 'DOC004', 'Emily', 'Davis', 'Jones', 'J003');

INSERT INTO invoice (due_date, document_type, document_number, name, last_name, last_name2, cod_jefe)
VALUES (TO_DATE('2024-08-19', 'YYYY-MM-DD'), 'Type2', 'DOC005', 'Anna', 'Martinez', 'García', 'J002');

INSERT INTO invoice (due_date, document_type, document_number, name, last_name, last_name2, cod_jefe)
VALUES (TO_DATE('2024-08-20', 'YYYY-MM-DD'), 'Type1', 'DOC006', 'James', 'Wilson', 'Taylor', 'J004');

INSERT INTO invoice (due_date, document_type, document_number, name, last_name, last_name2, cod_jefe)
VALUES (TO_DATE('2024-08-21', 'YYYY-MM-DD'), 'Type3', 'DOC007', 'Olivia', 'Moore', 'Lee', 'J005');

INSERT INTO invoice (due_date, document_type, document_number, name, last_name, last_name2, cod_jefe)
VALUES (TO_DATE('2024-08-22', 'YYYY-MM-DD'), 'Type2', 'DOC008', 'Ethan', 'Anderson', 'Thomas', 'J001');

INSERT INTO invoice (due_date, document_type, document_number, name, last_name, last_name2, cod_jefe)
VALUES (TO_DATE('2024-08-23', 'YYYY-MM-DD'), 'Type1', 'DOC009', 'Sophia', 'White', 'Harris', 'J003');

INSERT INTO invoice (due_date, document_type, document_number, name, last_name, last_name2, cod_jefe)
VALUES (TO_DATE('2024-08-24', 'YYYY-MM-DD'), 'Type2', 'DOC010', 'Ava', 'Clark', 'Lewis', 'J002');
