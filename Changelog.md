
---

### 🧱 Version 1.0 – The Foundation

**refactor:** Major cleanup for better readability & maintainability 💅

* 🧼 Moved business logic from the controller to the service layer — controllers deserve some peace too.
* ✂️ Split the controller into `API interface` + `implementation` — because single responsibility matters.
* 🛡️ Added `GlobalExceptionHandler` — no more messy `try-catch` blocks everywhere.
* 📦 Introduced a proper `ErrorMessage` model — structured errors > plain strings.
* 🧠 Created an `AbstractExceptionHandler` — consistent and clean exception flow, the modern way.

---

### 🚀 Version 2.0 – The Upgrade

**feat:** API versioning, DTOs, enums, and SOLID principles 🧩

* 🧭 **Enabled API versioning** — future-proofing your endpoints like a pro.
* 🧾 **Added enums** for `Currency`, `InvoiceStatus`, and `Vendor` — bye-bye magic strings 👋
* 🪪 **Created `InvoiceResponseDto`** — exposing entities is so last season.
* 🧱 **Separated `Service` and `ServiceImpl`** — because clean architecture and SOLID principles go hand in hand.
* 🛠️ **Mapper added** — simplifying conversions between entities and DTOs.
* 📝 **Created `UploadInvoiceDto`** — making invoice creation more structured.

👉 In Version 3, I might add security features and further improvements, but if this version is not reviewed and either merged or declined, I’ll consider stopping development.
