PGDMP     	                    z            films    14.1    14.1 	    ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    18324    films    DATABASE     a   CREATE DATABASE films WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Italian_Italy.1252';
    DROP DATABASE films;
                postgres    false            ?            1259    18326    film    TABLE     ?   CREATE TABLE public.film (
    id integer NOT NULL,
    anno integer,
    incasso character varying(255),
    regista character varying(255),
    tipo character varying(255),
    titolo character varying(255)
);
    DROP TABLE public.film;
       public         heap    postgres    false            ?            1259    18325    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            ?          0    18326    film 
   TABLE DATA           H   COPY public.film (id, anno, incasso, regista, tipo, titolo) FROM stdin;
    public          postgres    false    210   {       ?           0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 10, true);
          public          postgres    false    209            ]           2606    18332    film film_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.film
    ADD CONSTRAINT film_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.film DROP CONSTRAINT film_pkey;
       public            postgres    false    210            ?   ?  x?m?ɒ?@?3<?>+?"s?ٗv??XH)PXP?<?`G?}?K?????AUe?C?aj?????e??wB[??2ϒMel?O?L3?7v3?a?x#? ?՘I
??&?eÙ(??Y?y^zS??|ze??B!????S8??V)v3z74?T9?$C?sK?{ ????????%? '??H	??ZIZ:?%??;t?˲??2??Q˖????R????ᮧ???7&?0ia???܆???@?
??)oM?L?6?7e?Z}QQ?n*S?0[M?fK??ѳ#t-1????O?]?t???????:??] ??*??Z"?P?Þ?|j_???F?nK7???{c0fyŸY? ?A?k ?? ?wN	?"ܶ?U^???	*R-Y>*s;Hv?W?nxɿ?p7Vai???????KE?B;V??b?qT<!?lJ?<^x??SܷW?.^ɈoDS????,?:???E??ɬ??l??^???s۹???nZ??3??p?h??*???v????U???K[ׇ( 뇾.?C?/f??z?>OI???ڀu|?A??eF?M>al??]?5?? Ƥc?\؁?{?;V?_M?????W????)?Uo?u??$9?e????kj42?n?????OU-?9??W?K4 ?f???%l ????;aY??Y?     