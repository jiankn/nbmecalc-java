# NBMEcalc developer backlink ledger

Last audited: 2026-08-03

## Summary

- Canonical target: https://nbmecalc.com
- Completed public listings: 1
- Unique referring root domains: 1 (`github.io`)
- Pending: Maven Central package page
- Blocked: Maven Central account namespace, token, and signing secrets
- Rejected after qualification: 6 platforms

## Platforms

| Platform | Root domain | Public URL | Asset type | Link location | rel tokens | Index directives | Status | Evidence / next action |
|---|---|---|---|---|---|---|---|---|
| GitHub Pages | github.io | https://jiankn.github.io/nbmecalc-java/ | Java API documentation | Javadoc overview | none | HTTP 200; no `noindex`; no `X-Robots-Tag` | Complete | Exact target anchor verified 2026-08-03 |
| Maven Central | sonatype.com | Pending | Java library | POM Project URL | expected `noreferrer` | Representative page HTTP 200; no `noindex`; no `X-Robots-Tag` | Pending | `io.github.jiankn:nbmecalc-core:1.0.0` is available; publish after account and secret setup, then audit final page |
| Read the Docs | readthedocs.io | Not created | API documentation | Documentation prose | none on representative page | HTTP 200; no `noindex`; no `X-Robots-Tag` | Qualified / deferred | Extra account and duplicate documentation maintenance; revisit after Maven Central release |
| CocoaPods | cocoapods.org | Not created | Swift library | Documentation metadata | none on representative page | HTTP 200; no `noindex`; no `X-Robots-Tag` | Qualified / deferred | Requires a maintained Swift implementation and macOS release path |
| JSR | jsr.io | Not created | TypeScript package | Rendered README product link | `nofollow` | HTTP 200; no `noindex`; no `X-Robots-Tag` | Rejected | Product-site link failed followability gate; verified repository link behavior does not help the canonical target |
| NuGet | nuget.org | Not created | .NET package | Homepage / documentation | `nofollow noopener noreferrer` | HTTP 200; no `noindex`; no `X-Robots-Tag` | Rejected | Failed followability gate |
| Packagist | packagist.org | Not created | PHP package | Homepage / README | `external nofollow noindex noopener ugc` | HTTP 200; no `noindex`; no `X-Robots-Tag` | Rejected | Failed followability gate |
| RubyGems | rubygems.org | Not created | Ruby package | Homepage | `nofollow` | HTTP 200; no `noindex`; no `X-Robots-Tag` | Rejected | Failed followability gate |
| VS Marketplace | marketplace.visualstudio.com | Not created | VS Code extension | README / repository links | `nofollow noopener noreferrer` | HTTP 200; no `noindex`; no `X-Robots-Tag` | Rejected | Failed followability gate |
| Libraries.io | libraries.io | Not created | Registry mirror | Homepage / README | `nofollow` | HTTP 200; no `noindex`; no `X-Robots-Tag` | Rejected | Failed followability gate |

Completed counts only include public pages where the final target link and page directives were directly audited. Multiple pages on the same root domain are deduplicated when counting referring domains.
