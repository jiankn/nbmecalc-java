# NBMEcalc developer backlink ledger

Last audited: 2026-08-04

## Summary

- Canonical target: https://nbmecalc.com
- Completed public listings: 11
- Unique referring root domains: 11 (`github.io`, `sonatype.com`, `codeberg.org`, `gitea.com`, `gitbook.io`, `readthedocs.io`, `docs.rs`, `clojars.org`, `cocoapods.org`, `code.dlang.org`, `smithery.ai`)
- Pending / prepared: 2 platform surfaces
- Blocked: 1 platform (`hackage.haskell.org`)
- Skipped by owner: 1 platform (`lib.haxe.org`)
- Rejected after qualification: 11 platforms

## Platforms

| Platform | Root domain | Public URL | Asset type | Link location | rel tokens | Index directives | Status | Evidence / next action |
|---|---|---|---|---|---|---|---|---|
| GitHub Pages | github.io | https://jiankn.github.io/nbmecalc-java/ | Java API documentation | Javadoc overview | none | HTTP 200; no `noindex`; no `X-Robots-Tag` | Complete | Exact target anchor verified 2026-08-03 |
| Maven Central | sonatype.com | https://central.sonatype.com/artifact/io.github.jiankn/nbmecalc-core/1.0.0 | Java library | POM Project URL | `noreferrer` | HTTP 200; canonical present; no `noindex`; no `X-Robots-Tag` | Complete | POM, main JAR, sources JAR, and Javadoc JAR returned HTTP 200; exact target anchor verified 2026-08-03. Central search API indexing is still propagating. |
| Read the Docs | readthedocs.io | https://nbmecalc-developer-docs.readthedocs.io/ | Developer documentation | Documentation prose | none | HTTP 200; no `noindex`; no `X-Robots-Tag`; canonical present | Complete | Build 33891402 succeeded from commit `a154bcd`; exact target anchor and public sitemap verified 2026-08-04 |
| CocoaPods | cocoapods.org | https://cocoapods.org/pods/NBMEcalc | Swift library | Homepage metadata | none | HTTP 200; no `noindex`; no `X-Robots-Tag` | Complete | `NBMEcalc` 1.0.4 published; exact followable Homepage target anchor verified 2026-08-04. A separate rendered README link is `nofollow` and is not counted. |
| JSR | jsr.io | Not created | TypeScript package | Rendered README product link | `nofollow` | HTTP 200; no `noindex`; no `X-Robots-Tag` | Rejected | Product-site link failed followability gate; verified repository link behavior does not help the canonical target |
| NuGet | nuget.org | Not created | .NET package | Homepage / documentation | `nofollow noopener noreferrer` | HTTP 200; no `noindex`; no `X-Robots-Tag` | Rejected | Failed followability gate |
| Packagist | packagist.org | Not created | PHP package | Homepage / README | `external nofollow noindex noopener ugc` | HTTP 200; no `noindex`; no `X-Robots-Tag` | Rejected | Failed followability gate |
| RubyGems | rubygems.org | Not created | Ruby package | Homepage | `nofollow` | HTTP 200; no `noindex`; no `X-Robots-Tag` | Rejected | Failed followability gate |
| VS Marketplace | marketplace.visualstudio.com | Not created | VS Code extension | README / repository links | `nofollow noopener noreferrer` | HTTP 200; no `noindex`; no `X-Robots-Tag` | Rejected | Failed followability gate |
| Libraries.io | libraries.io | Not created | Registry mirror | Homepage / README | `nofollow` | HTTP 200; no `noindex`; no `X-Robots-Tag` | Rejected | Failed followability gate |
| Codeberg | codeberg.org | https://codeberg.org/jiankn/nbmecalc-java | Java library mirror | Repository Website field | none | HTTP 200; no `noindex`; no `X-Robots-Tag` | Complete | Exact target anchor verified 2026-08-03; a separate README link is `nofollow`, while the repository Website link is followable |
| Gitea.com | gitea.com | https://gitea.com/jiankn/nbmecalc-java | Java library mirror | Repository Website field | none | HTTP 200; no `noindex`; no `X-Robots-Tag` | Complete | Exact target anchor verified 2026-08-03; a separate README link is `nofollow`, while the repository Website link is followable |
| GitBook | gitbook.io | https://savepinner.gitbook.io/nbmecalc-developer-documentation | Developer guide | Documentation prose | none | HTTP 200; `index, follow`; canonical present | Complete | Exact target anchor verified 2026-08-03 |
| DEV Community | dev.to | https://dev.to/jiankn/building-an-uncertainty-aware-practice-exam-score-calculator-in-java-15og | Technical tutorial | Article prose | `noopener noreferrer` | HTTP 200; `noindex, nofollow`; self-canonical | Published / indexing pending | Exact target anchor is followable, but the page currently fails the indexability gate. DEV API reported 0 reactions; re-audit after platform scoring or moderation. |
| pkg.go.dev | pkg.go.dev | https://pkg.go.dev/github.com/jiankn/nbmecalc-go | Go library | Package documentation | pending final audit | HTTP 200; no `noindex`; canonical present | Published / propagating | v1.0.2 adds the exact project URL to the Go package documentation; CI passed and proxy.golang.org serves the tag, while pkg.go.dev propagation is pending |
| docs.rs | docs.rs | https://docs.rs/nbmecalc/latest/nbmecalc/ | Rust library documentation | Homepage metadata and crate documentation | none | HTTP 200; no `noindex`; no `X-Robots-Tag` | Complete | crates.io v1.0.1 is public and not yanked; two exact followable target anchors verified 2026-08-04 |
| Clojars | clojars.org | https://clojars.org/net.clojars.jiankn/nbmecalc | Clojure library | Project URL | none | HTTP 200; no `noindex`; no `X-Robots-Tag` | Complete | Clojars API confirms v1.0.2; exact target anchor verified 2026-08-04 |
| Hackage | hackage.haskell.org | Not published | Haskell library | Homepage metadata | none on representative page | HTTP 200; no `noindex`; canonical present | Blocked / uploader approval | v1.0.1.1 passed build, test, `cabal check`, and `sdist`; upload reached Hackage but returned HTTP 403 because account is not in the Uploaders group. Requires Hackage trustee approval. |
| DUB | code.dlang.org | https://code.dlang.org/packages/nbmecalc | D library | Homepage and README | none | HTTP 200; no `noindex`; no `X-Robots-Tag` | Complete | DUB serves v1.0.1; two exact followable target anchors verified 2026-08-04 |
| Haxelib | lib.haxe.org | Not published | Haxe library | Project URL and README | none on representative page | HTTP 200; no `noindex`; no `X-Robots-Tag` | Skipped / credential unavailable | `jiankn` account exists but its password is unavailable; owner chose not to pursue the manual maintainer-assisted reset. Prepared v1.0.1 release and workflow are retained. |
| Smithery | smithery.ai | https://smithery.ai/servers/jiankn/nbmecalc | Remote MCP server | Homepage metadata | `noopener noreferrer` | HTTP 200; no `noindex`; no `X-Robots-Tag` | Complete | Streamable HTTP scan and release succeeded; exact followable Homepage target anchor verified 2026-08-04 |
| PyPI | pypi.org | Not created | Python package | Homepage / rendered README | `nofollow` | HTTP 200; no `noindex`; canonical present | Rejected | Failed followability gate after rendered-DOM audit |
| cljdoc | cljdoc.org | Not created | Clojure documentation | Rendered README | `nofollow` | HTTP 200; no `noindex` | Rejected | Failed followability gate; Clojars itself remains qualified |
| Hex / HexDocs | hex.pm / hexdocs.pm | Not created | Elixir package and docs | Homepage / README | `nofollow` | HTTP 200; no `noindex` | Rejected | Both package and generated documentation target links failed followability gate |
| pub.dev | pub.dev | Not created | Dart package | Homepage / README | `ugc` | HTTP 200; `noindex`; canonical present | Rejected | Failed both indexability and followability gates |
| Raku Land | raku.land | Not created | Raku module | Rendered README | `nofollow` | HTTP 200; no `noindex`; canonical present | Rejected | Failed followability gate |

Completed counts only include public pages where the final target link and page directives were directly audited. Multiple pages on the same root domain are deduplicated when counting referring domains.
