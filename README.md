# Prueba Tecnica Latam 2020

A continucación se detalla la instalación de los componenetes necesarios para deployar y ejecutar la prueba tecnica.

## Instalaciones

**1. Node**
Instalación [Node.js](https://nodejs.org/), instalarla versión LTS actual.
Para validar la instalación ejecutar el siguiente comando
```sh
$ node -v
```
**2. NPM**
Instalación [npm](https://www.npmjs.com/), última versión actual.
Para validar la instalación de npm ejecutar el siguiente comando:

```sh
$ npm -v
```
**3. Git**
Instalación de [Git](https://git-scm.com/)
Para validar la instalación de Git ejecutar el siguiente comando:
```sh
$ git --version
```

**4. sts**
Instalación de [sts](https://spring.io/tools), Bajar la última versión estable e instalar


## Descargar fuentes
Para bajar fuentes ejecute el siguiente comando
```sh
$ git clone https://github.com/HernanLoGo/PruebaTecnicaLatam.git
```


## Deployment

**- Backend**

Con el sts ya instalado, abrir el sts y seleccionar en la ruta 
```
PruebaTecnicaLatam\BackPruebaTecnica
```

Una vez cargado el proyecto en el sts, correr las pruebas unitarias.

Una vez validadas, levantar el proyecto.



**- Frontend**

Acceda al directorio donde descargó las fuentas y acceda al directorio frontPruebaTecnica
```sh
$ cd frontPruebaTecnica
```
 
Para ambientar el proyecto de angular ejecute lo
```sh
$ npm install
```
 
Una vez descargado todas las dependencias, levantamos el servidor usando el comando
```sh
$ npm start
```

En caso de que aparesca el mensaje
```sh
You must set the PowerShell Execution Policy from Restricted to RemoteSigned or Unrestricted to allow local PowerShell scripts to run.
```

Ejecutar el siguiente comando para solucionar el problema
```sh
$ Set-ExecutionPolicy Unrestricted
```


 Una vez listo podemos acceder al front desde la siguiente url y usar la aplicacion
 ```sh
$ http://localhost:4200/
```

