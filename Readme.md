


# Screenshots

## 1 GET /api/v1/astronauts?sort=experienceYears requests

## 1.1 Implicit ASC order

<img src="./screenshots/01-get-astronauts-implicit-order.png" />

## 1.2 DESC order using order property

<img src="./screenshots/02-get-astronauts-explicit-order.png" />

---

## 2. POST /api/v1/astronauts requests

### 2.1 Satellite not found
<img src="./screenshots/03-add-astronaut-with-not-found-satelites.png" />

### 2.2 Satellite found, successfully saved

<img src="./screenshots/04-add-astronaut-with-existing-satellites.png" />


---
## 3. PUT /api/v1/satellites/:satelliteId Requests

### 3.1 Duplicate satelite name error

<img src="./screenshots/05-update-satellite-duplicate-name.png" />

### 3.2 OrbitType pattern not matched
<img src="./screenshots/06-update-satellite-orbitType-pattern-not-matched.png" />

### 3.3 Satelite is already decommisioned, cannot updated
<img src="./screenshots/07-update-satellite-already-decommisioned.png" />

## 3.4 Satelite is updated successfully
<img src="./screenshots/08-update-satellite-success.png">
