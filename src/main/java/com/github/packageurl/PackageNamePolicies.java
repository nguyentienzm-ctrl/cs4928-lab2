package com.github.packageurl;

class PackageNamePolicies {

    static final PackageNamePolicy PRESERVE = value -> value;

    static final PackageNamePolicy LOWERCASE = value -> value.toLowerCase();

    static final PackageNamePolicy PUB = value ->
            value.toLowerCase().replaceAll("[^a-z0-9_]", "_");

    static final PackageNamePolicy PYPI = value ->
            value.toLowerCase().replace('_', '-');

    static PackageNamePolicy forType(String type) {
        if (type == null) {
            return PRESERVE;
        }

        switch (type) {
            // Bổ sung đầy đủ các loại package dùng chung luật LOWERCASE
            case PackageURL.StandardTypes.APK:
            case PackageURL.StandardTypes.BITBUCKET:
            case PackageURL.StandardTypes.BITNAMI:
            case PackageURL.StandardTypes.COMPOSER:
            case PackageURL.StandardTypes.DEB:
            case PackageURL.StandardTypes.GITHUB:
            case PackageURL.StandardTypes.GOLANG:
            case PackageURL.StandardTypes.HEX:
            case PackageURL.StandardTypes.LUAROCKS:
            case PackageURL.StandardTypes.OCI:
                return LOWERCASE;

            case PackageURL.StandardTypes.PYPI:
                return PYPI;

            case PackageURL.StandardTypes.PUB:
                return PUB;

            default:
                return PRESERVE;
        }
    }
}
