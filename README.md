\# AERIS Alpha



\## Descripción



AERIS Alpha es un ERP de escritorio desarrollado en Java 21 para la administración de empresas dedicadas al alquiler de recursos, gestión de clientes, reservas, pagos y reportes.



Actualmente se encuentra en fase Alpha y está siendo desarrollado bajo una arquitectura modular orientada al crecimiento.



\---



\# Tecnologías



\- Java 21

\- Maven

\- Swing

\- FlatLaf

\- MigLayout

\- PostgreSQL

\- Supabase

\- BCrypt



\---



\# Arquitectura



El proyecto está dividido en capas.



```

UI

↓



Service



↓



Repository



↓



Database

```



Toda la lógica de negocio se implementa en Service.



Toda consulta SQL pertenece únicamente a Repository.



La interfaz nunca accede directamente a la base de datos.



\---



\# Módulos



\- Login

\- Dashboard

\- Clientes

\- Recursos

\- Reservas

\- Pagos

\- Reportes

\- Administración



\---



\# Estado del proyecto



Versión actual:



Alpha 0.1



\---



\# Objetivo



Construir un ERP moderno, rápido, escalable y profesional para pequeñas y medianas empresas de alquiler de recursos.



\---



\# Equipo



Proyecto desarrollado por:



Yasser Cardenas



Asistencia técnica:



OpenAI ChatGPT + Codex

