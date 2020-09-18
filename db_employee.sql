PGDMP                         x            db_employee    12.3    12.3     #           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            $           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            %           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            &           1262    17018    db_employee    DATABASE     �   CREATE DATABASE db_employee WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_Indonesia.1252' LC_CTYPE = 'English_Indonesia.1252';
    DROP DATABASE db_employee;
                postgres    false            �            1259    17029    division    TABLE     c   CREATE TABLE public.division (
    div_id integer NOT NULL,
    div_name character varying(255)
);
    DROP TABLE public.division;
       public         heap    postgres    false            �            1259    17027    division_div_id_seq    SEQUENCE     �   CREATE SEQUENCE public.division_div_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.division_div_id_seq;
       public          postgres    false    205            '           0    0    division_div_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.division_div_id_seq OWNED BY public.division.div_id;
          public          postgres    false    204            �            1259    17141    employee    TABLE     7  CREATE TABLE public.employee (
    employee_id integer NOT NULL,
    created_date timestamp without time zone,
    last_position character varying(255),
    name character varying(255),
    nik character varying(255),
    type character varying(255),
    div_id integer NOT NULL,
    pos_id integer NOT NULL
);
    DROP TABLE public.employee;
       public         heap    postgres    false            �            1259    17139    employee_employee_id_seq    SEQUENCE     �   CREATE SEQUENCE public.employee_employee_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.employee_employee_id_seq;
       public          postgres    false    209            (           0    0    employee_employee_id_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.employee_employee_id_seq OWNED BY public.employee.employee_id;
          public          postgres    false    208            �            1259    17077    id    SEQUENCE     l   CREATE SEQUENCE public.id
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    DROP SEQUENCE public.id;
       public          postgres    false            �            1259    17097    nik    SEQUENCE     m   CREATE SEQUENCE public.nik
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    DROP SEQUENCE public.nik;
       public          postgres    false            �            1259    17021    position    TABLE     |   CREATE TABLE public."position" (
    pos_id integer NOT NULL,
    pos_level integer,
    pos_name character varying(255)
);
    DROP TABLE public."position";
       public         heap    postgres    false            �            1259    17019    position_pos_id_seq    SEQUENCE     �   CREATE SEQUENCE public.position_pos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.position_pos_id_seq;
       public          postgres    false    203            )           0    0    position_pos_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.position_pos_id_seq OWNED BY public."position".pos_id;
          public          postgres    false    202            �
           2604    17032    division div_id    DEFAULT     r   ALTER TABLE ONLY public.division ALTER COLUMN div_id SET DEFAULT nextval('public.division_div_id_seq'::regclass);
 >   ALTER TABLE public.division ALTER COLUMN div_id DROP DEFAULT;
       public          postgres    false    205    204    205            �
           2604    17144    employee employee_id    DEFAULT     |   ALTER TABLE ONLY public.employee ALTER COLUMN employee_id SET DEFAULT nextval('public.employee_employee_id_seq'::regclass);
 C   ALTER TABLE public.employee ALTER COLUMN employee_id DROP DEFAULT;
       public          postgres    false    209    208    209            �
           2604    17024    position pos_id    DEFAULT     t   ALTER TABLE ONLY public."position" ALTER COLUMN pos_id SET DEFAULT nextval('public.position_pos_id_seq'::regclass);
 @   ALTER TABLE public."position" ALTER COLUMN pos_id DROP DEFAULT;
       public          postgres    false    203    202    203                      0    17029    division 
   TABLE DATA           4   COPY public.division (div_id, div_name) FROM stdin;
    public          postgres    false    205   �!                  0    17141    employee 
   TABLE DATA           m   COPY public.employee (employee_id, created_date, last_position, name, nik, type, div_id, pos_id) FROM stdin;
    public          postgres    false    209   �!                 0    17021    position 
   TABLE DATA           A   COPY public."position" (pos_id, pos_level, pos_name) FROM stdin;
    public          postgres    false    203   �"       *           0    0    division_div_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.division_div_id_seq', 1, false);
          public          postgres    false    204            +           0    0    employee_employee_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.employee_employee_id_seq', 13, true);
          public          postgres    false    208            ,           0    0    id    SEQUENCE SET     1   SELECT pg_catalog.setval('public.id', 1, false);
          public          postgres    false    206            -           0    0    nik    SEQUENCE SET     2   SELECT pg_catalog.setval('public.nik', 1, false);
          public          postgres    false    207            .           0    0    position_pos_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.position_pos_id_seq', 1, false);
          public          postgres    false    202            �
           2606    17034    division division_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.division
    ADD CONSTRAINT division_pkey PRIMARY KEY (div_id);
 @   ALTER TABLE ONLY public.division DROP CONSTRAINT division_pkey;
       public            postgres    false    205            �
           2606    17149    employee employee_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (employee_id);
 @   ALTER TABLE ONLY public.employee DROP CONSTRAINT employee_pkey;
       public            postgres    false    209            �
           2606    17026    position position_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public."position"
    ADD CONSTRAINT position_pkey PRIMARY KEY (pos_id);
 B   ALTER TABLE ONLY public."position" DROP CONSTRAINT position_pkey;
       public            postgres    false    203            �
           2606    17150 $   employee fk2vpvjob4iw7mj2vu1id3g367g    FK CONSTRAINT     �   ALTER TABLE ONLY public.employee
    ADD CONSTRAINT fk2vpvjob4iw7mj2vu1id3g367g FOREIGN KEY (div_id) REFERENCES public.division(div_id);
 N   ALTER TABLE ONLY public.employee DROP CONSTRAINT fk2vpvjob4iw7mj2vu1id3g367g;
       public          postgres    false    209    205    2710            �
           2606    17155 $   employee fkoghryrveqv9p5wi2k6pmtrhrx    FK CONSTRAINT     �   ALTER TABLE ONLY public.employee
    ADD CONSTRAINT fkoghryrveqv9p5wi2k6pmtrhrx FOREIGN KEY (pos_id) REFERENCES public."position"(pos_id);
 N   ALTER TABLE ONLY public.employee DROP CONSTRAINT fkoghryrveqv9p5wi2k6pmtrhrx;
       public          postgres    false    2708    203    209               /   x�3���2��r�2�t��K�KN�2�(�O/J��M-����� ��

          �   x��һnA�z�+�X~��]

�ݍ %�6H� ���3D(b�$�k]K��WXWT^()��9�۝�����i:On߻���w�ĳuE�A�<qb��R ��\0.4Z�
������c��1��������d�(%���/��k�Cg��MK��t�鬘+p�t5��S(?����,�J9��x�6�o�D�v�e�b9�y(l�.���{�,�L         ?   x�3�4�.ILK�2�4�.-H-*�,�/�2�4�t,�,.I�S�M�KLO-�2�4ᄱc���� 'mP     