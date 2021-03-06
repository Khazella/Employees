/*
PostgreSQL Backup
Database: db_employee/public
Backup Time: 2020-09-18 22:02:52
*/

DROP SEQUENCE IF EXISTS "public"."division_div_id_seq";
DROP SEQUENCE IF EXISTS "public"."employee_employee_id_seq";
DROP SEQUENCE IF EXISTS "public"."id";
DROP SEQUENCE IF EXISTS "public"."nik";
DROP SEQUENCE IF EXISTS "public"."position_pos_id_seq";
DROP TABLE IF EXISTS "public"."division";
DROP TABLE IF EXISTS "public"."employee";
DROP TABLE IF EXISTS "public"."position";
CREATE SEQUENCE "division_div_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
CREATE SEQUENCE "employee_employee_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
CREATE SEQUENCE "id" 
INCREMENT 50
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
CREATE SEQUENCE "nik" 
INCREMENT 50
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
CREATE SEQUENCE "position_pos_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
CREATE TABLE "division" (
  "div_id" int4 NOT NULL DEFAULT nextval('division_div_id_seq'::regclass),
  "div_name" varchar(255) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "division" OWNER TO "postgres";
CREATE TABLE "employee" (
  "employee_id" int4 NOT NULL DEFAULT nextval('employee_employee_id_seq'::regclass),
  "created_date" timestamp(6),
  "last_position" varchar(255) COLLATE "pg_catalog"."default",
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "nik" varchar(255) COLLATE "pg_catalog"."default",
  "type" varchar(255) COLLATE "pg_catalog"."default",
  "div_id" int4 NOT NULL,
  "pos_id" int4 NOT NULL
)
;
ALTER TABLE "employee" OWNER TO "postgres";
CREATE TABLE "position" (
  "pos_id" int4 NOT NULL DEFAULT nextval('position_pos_id_seq'::regclass),
  "pos_level" int4,
  "pos_name" varchar(255) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "position" OWNER TO "postgres";
BEGIN;
LOCK TABLE "public"."division" IN SHARE MODE;
DELETE FROM "public"."division";
INSERT INTO "public"."division" ("div_id","div_name") VALUES (1, 'IT'),(2, 'HRD'),(3, 'Finance'),(4, 'Programmer');
COMMIT;
BEGIN;
LOCK TABLE "public"."employee" IN SHARE MODE;
DELETE FROM "public"."employee";
INSERT INTO "public"."employee" ("employee_id","created_date","last_position","name","nik","type","div_id","pos_id") VALUES (1, '2020-09-18 16:20:56.772', 'Staff', 'Nomoto', NULL, 'PROMOTION', 2, 3),(2, '2020-09-18 16:28:12.343', 'Staff', 'Nomoto', NULL, 'PROMOTION', 2, 3),(3, '2020-09-18 16:31:14.093', 'Staff', 'Nomoto', NULL, 'PROMOTION', 2, 3),(4, '2020-09-18 16:46:39.181', 'Staff', 'Aji', NULL, 'PROMOTION', 1, 2),(5, '2020-09-18 16:52:57.364', 'Staff', 'Aji', 'EM00000', 'PROMOTION', 1, 2),(6, '2020-09-18 16:53:16.047', 'Staff', 'Maulana', 'EM00000', 'PROMOTION', 1, 2),(7, '2020-09-18 16:55:16.345', 'Staff', 'Maulana', 'EM00000', 'PROMOTION', 1, 2),(8, '2020-09-18 17:06:09.274', 'Staff', 'Maulana', 'EM00000', 'PROMOTION', 1, 2),(9, '2020-09-18 17:16:20.872', 'Staff', 'Maulana', 'EM00000', 'PROMOTION', 1, 2),(11, '2020-09-18 17:19:13.768', 'Staff', 'Maulana', 'EM00011', 'PROMOTION', 1, 2),(12, '2020-09-18 17:20:19.231', 'Staff', 'Maulana', 'EM00000', 'PROMOTION', 1, 2),(13, '2020-09-18 17:21:31.364', 'Staff', 'Maulana', 'EM00013', 'PROMOTION', 1, 2);
COMMIT;
BEGIN;
LOCK TABLE "public"."position" IN SHARE MODE;
DELETE FROM "public"."position";
INSERT INTO "public"."position" ("pos_id","pos_level","pos_name") VALUES (1, 1, 'Staff'),(2, 2, 'Supervisor'),(3, 3, 'Asisten Manager'),(4, 4, 'Manager');
COMMIT;
ALTER TABLE "division" ADD CONSTRAINT "division_pkey" PRIMARY KEY ("div_id");
ALTER TABLE "employee" ADD CONSTRAINT "employee_pkey" PRIMARY KEY ("employee_id");
ALTER TABLE "position" ADD CONSTRAINT "position_pkey" PRIMARY KEY ("pos_id");
ALTER TABLE "employee" ADD CONSTRAINT "fk2vpvjob4iw7mj2vu1id3g367g" FOREIGN KEY ("div_id") REFERENCES "public"."division" ("div_id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "employee" ADD CONSTRAINT "fkoghryrveqv9p5wi2k6pmtrhrx" FOREIGN KEY ("pos_id") REFERENCES "public"."position" ("pos_id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER SEQUENCE "division_div_id_seq"
OWNED BY "division"."div_id";
SELECT setval('"division_div_id_seq"', 2, false);
ALTER SEQUENCE "division_div_id_seq" OWNER TO "postgres";
ALTER SEQUENCE "employee_employee_id_seq"
OWNED BY "employee"."employee_id";
SELECT setval('"employee_employee_id_seq"', 14, true);
ALTER SEQUENCE "employee_employee_id_seq" OWNER TO "postgres";
SELECT setval('"id"', 51, false);
ALTER SEQUENCE "id" OWNER TO "postgres";
SELECT setval('"nik"', 51, false);
ALTER SEQUENCE "nik" OWNER TO "postgres";
ALTER SEQUENCE "position_pos_id_seq"
OWNED BY "position"."pos_id";
SELECT setval('"position_pos_id_seq"', 2, false);
ALTER SEQUENCE "position_pos_id_seq" OWNER TO "postgres";
