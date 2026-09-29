# Baseline
* Pinned SHA: cf437186b2ae2d9100a187e0df3cce3a163e9b4b
* Upstream test result: Passed
* CS4928_BASELINE tag: Created
* CS4928 checker result: Passed

# Problem A
validateName mixes general validation with package-type-specific normalisation.
Goal: move the varying name-normalisation algorithm behind a stable policy while preserving every existing result.

# Refactoring A
* Files/classes changed: PackageURL.java, PackageNamePolicy.java, PackageNamePolicies.java.
* Tests after the change: Passed.
* First commit SHA: 59603b84594ce1b44364ccd8bf2a8619d324271f
* Before -> After: Moved type-specific string normalization from a switch block to a stable PackageNamePolicies resolver.

# Problem B
Qualifier-key canonicalisation is shared to enforce a single rule (lowercase), but the two input paths remain separate because string parsing explicitly detects duplicates while map parsing has its own filtering behavior.

# Refactoring B
* Helper canonicalizeQualifierKey introduced.
* Tests after the change: Passed.
* Second commit SHA: 62fbfc1f7b664a9ce917dc8cb101d517c1e99c86
* Before -> After: Replaced inline lowercase expressions with a centralized helper.

# Problem C
A good refactoring experiment must be bounded, testable, and small enough to understand, which is why wider variation is left for later.

# Final judgement
I would keep both changes.
* Benefit: Creates a single source of truth for business rules.
* Trade-off: Introduces slightly more abstraction with new files and interfaces.

# Repository
* URL: https://github.com/nguyentienzm-ctrl/cs4928-lab2 
