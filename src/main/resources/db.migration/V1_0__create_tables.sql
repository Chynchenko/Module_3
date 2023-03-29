CREATE TABLE IF NOT EXISTS public.lesson
 (
     id character varying(255) COLLATE pg_catalog."default" NOT NULL,
     name character varying(255) COLLATE pg_catalog."default",
     CONSTRAINT subject_pkey PRIMARY KEY (id)
 )
 TABLESPACE pg_default;
 ALTER TABLE IF EXISTS public.lesson
     OWNER to postgres;

 CREATE TABLE IF NOT EXISTS public.lector
 (
     id character varying(255) COLLATE pg_catalog."default" NOT NULL,
     age integer NOT NULL,
     firstname character varying(255) COLLATE pg_catalog."default",
     surname character varying(255) COLLATE pg_catalog."default",
     subject_id character varying(255) COLLATE pg_catalog."default",
     CONSTRAINT lector_pkey PRIMARY KEY (id),
     CONSTRAINT fk6e33amanj82xu1aebk6jwb1sg FOREIGN KEY (lesson_id)
         REFERENCES public.lesson (id) MATCH SIMPLE
         ON UPDATE NO ACTION
         ON DELETE NO ACTION
 )
 TABLESPACE pg_default;
 ALTER TABLE IF EXISTS public.lector
     OWNER to postgres;


 CREATE TABLE IF NOT EXISTS public.groups
 (
     id character varying(255) COLLATE pg_catalog."default" NOT NULL,
     name character varying(255) COLLATE pg_catalog."default",
     CONSTRAINT groups_pkey PRIMARY KEY (id)
 )
 TABLESPACE pg_default;
 ALTER TABLE IF EXISTS public.groups
     OWNER to postgres;


 CREATE TABLE IF NOT EXISTS public.student
 (
     id character varying(255) COLLATE pg_catalog."default" NOT NULL,
     age integer NOT NULL,
     firstname character varying(255) COLLATE pg_catalog."default",
     receiptdate date,
     surname character varying(255) COLLATE pg_catalog."default",
     group_id character varying(255) COLLATE pg_catalog."default",
     CONSTRAINT student_pkey PRIMARY KEY (id),
     CONSTRAINT fkkch5m85ofgnmjqj4yth0b9urn FOREIGN KEY (group_id)
         REFERENCES public.groups (id) MATCH SIMPLE
         ON UPDATE NO ACTION
         ON DELETE NO ACTION
 )
 TABLESPACE pg_default;
 ALTER TABLE IF EXISTS public.student
     OWNER to postgres;


 CREATE TABLE IF NOT EXISTS public.mark
 (
     id character varying(255) COLLATE pg_catalog."default" NOT NULL,
     value integer NOT NULL,
     student_id character varying(255) COLLATE pg_catalog."default",
     lesson_id character varying(255) COLLATE pg_catalog."default",
     CONSTRAINT mark_pkey PRIMARY KEY (id),
     CONSTRAINT fk9d6a1x40ls199ooga5ph7nrhf FOREIGN KEY (subject_id)
         REFERENCES public.subject (id) MATCH SIMPLE
         ON UPDATE NO ACTION
         ON DELETE NO ACTION,
     CONSTRAINT fkm4o7m5fgtpve3u4cit85sch1n FOREIGN KEY (student_id)
         REFERENCES public.student (id) MATCH SIMPLE
         ON UPDATE NO ACTION
         ON DELETE NO ACTION
 )
 TABLESPACE pg_default;
 ALTER TABLE IF EXISTS public.mark
     OWNER to postgres;