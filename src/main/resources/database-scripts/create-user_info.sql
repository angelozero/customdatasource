-- Table: public.user_info

-- DROP TABLE IF EXISTS public.user_info;

CREATE TABLE IF NOT EXISTS public.user_info
(
    id integer NOT NULL DEFAULT nextval('user_info_id_seq'::regclass),
    name character varying COLLATE pg_catalog."default",
    CONSTRAINT user_info_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.user_info
    OWNER to master;