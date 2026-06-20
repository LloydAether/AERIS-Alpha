\# ARCHITECTURE.md



\# Arquitectura de AERIS Alpha



\## Objetivo



Este documento describe la arquitectura actual de AERIS Alpha y define cómo deben organizarse las clases, responsabilidades y flujos del sistema.



AERIS utiliza una arquitectura por capas para mantener el código ordenado, escalable y fácil de mantener.



\---



\# Stack técnico



\- Java 21

\- Maven

\- Swing

\- FlatLaf

\- MigLayout

\- PostgreSQL

\- Supabase

\- BCrypt



\---



\# Arquitectura general



El flujo obligatorio del sistema es:



```text

UI

&#x20;↓

Service

&#x20;↓

Repository

&#x20;↓

Database

